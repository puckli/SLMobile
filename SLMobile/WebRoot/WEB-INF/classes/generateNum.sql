USE [sldldcs]
GO

/****** Object:  StoredProcedure [dbo].[generateNum]    Script Date: 2014/10/13 11:11:00 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Create date: <2014-03-13>
-- Description:	<生成三联单的字号、集字号、本部id，需要传入参数三联单id>
-- =============================================
CREATE PROCEDURE [dbo].[generateNum]
	-- Add the parameters for the stored procedure here
	@sid int
AS
declare @jzh varchar(20),@zh varchar(20),@benbuid varchar(20),@company int,@bumen int,@jizi int,@jiziname varchar(20),@bumenjc varchar(10)
declare @tempzh varchar(10),@tempjzi varchar(10),@tempbenbuid varchar(10)
declare @year varchar(10),@month varchar(10)
declare @systemid int
BEGIN
	-- 初始化年月
	select @year=convert(varchar(10),DATEPART(YYYY,GETDATE()))
	select @month=RIGHT('0'+Convert(varchar(10),DATEPART(MM,GETDATE())),2)
	-- 获取公司部门等条件值
	select @company=gongsiID,@bumen=bumen,@jizi=jizi,@systemid=systems from SanLianCeShi where SID=@sid
	select @jiziname=j.jzname from sanlianceshi s,SLDjizi j where s.jizi=j.jid and s.sid=@sid
	select @bumenjc=bdx from SLDbm where bid=@bumen
	-- 分别查出最大的“号”
	select @tempzh=max(right(zh,4)) from SanLianCeShi s where s.jizi=@jizi and s.gongsiID=@company and s.zh like @year+@month+'%' and s.systems=@systemid and s.dr=0
	select @tempjzi=max(right(jzh,5)) from SanLianCeShi s,SLDjizi j where s.jizi=j.jid and substring(j.jzname,1,1)=substring(@jiziname,1,1) and s.jzh like @year+@month+'%' and s.systems=@systemid and s.dr=0
	select @tempbenbuid=max(right(benbuid,4)) from SanLianCeShi s where s.bumen=@bumen and s.benbuid like @bumenjc+@year+@month+'%' and s.systems=@systemid and s.dr=0

	-- 处理字号：zh
	if(@tempzh is not NULL)
		begin
			select @tempzh=right(('000'+CONVERT(varchar(10),CONVERT(int,@tempzh)+1)),4)
			select @zh = @year + @month + '-' + @tempzh
		end
	else
		begin
			select @zh = @year + @month + '-' + '0001'
		end

	-- 处理集字：jzi
	if(@tempjzi is not NULL)
		begin
			select @tempjzi=right(('0000'+CONVERT(varchar(10),CONVERT(int,@tempjzi)+1)),5)
			select @jzh = @year + @month + '-' + @tempjzi
		end
	else
		begin
			select @jzh = @year + @month + '-' + '00001'
		end

	-- 处理本部id： benbuid
	if(@tempbenbuid is not NULL)
		begin
			select @tempbenbuid=right(('000'+CONVERT(varchar(10),CONVERT(int,@tempbenbuid)+1)),4)
			select @benbuid = @bumenjc + @year + @month + @tempbenbuid
		end
	else
		begin
			select @benbuid = @bumenjc + @year + @month + '0001'
		end

	-- 更新三个号
	update SanLianCeShi set zh=@zh,jzh=@jzh,benbuid=@benbuid where SID=@sid

END

GO

