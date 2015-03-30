function symbol(s) {
	for ( var i = 1; i <= 11; i++) {
		document.getElementById("m" + i).innerHTML = "";
	}

	var c = s.indexOf(".");

	if (c > -1) {
		var st = s.split(".");
		if (st[1][1] != undefined) {
			document.getElementById("m1").innerHTML = st[1][1];
		} else if (st[1][1] == undefined) {
			document.getElementById("m1").innerHTML = 0;
		}

		if (st[1][0] != undefined) {
			document.getElementById("m2").innerHTML = st[1][0];
		}

		if (st[0][st[0].length - 1] != undefined) {
			document.getElementById("m3").innerHTML = st[0][st[0].length - 1];
		} else if (st[1][0] != undefined
				&& document.getElementById("m4").innerHTML == "") {
			document.getElementById("m3").innerHTML = "￥";
		}

		if (st[0][st[0].length - 2] != undefined) {
			document.getElementById("m4").innerHTML = st[0][st[0].length - 2];
		} else if (st[0][st[0].length - 1] != undefined
				&& document.getElementById("m5").innerHTML == "") {
			document.getElementById("m4").innerHTML = "￥";
		}

		if (st[0][st[0].length - 3] != undefined) {
			document.getElementById("m5").innerHTML = st[0][st[0].length - 3];
		} else if (st[0][st[0].length - 2] != undefined
				&& document.getElementById("m6").innerHTML == "") {
			document.getElementById("m5").innerHTML = "￥";
		}

		if (st[0][st[0].length - 4] != undefined) {
			document.getElementById("m6").innerHTML = st[0][st[0].length - 4];
		} else if (st[0][st[0].length - 3] != undefined
				&& document.getElementById("m7").innerHTML == "") {
			document.getElementById("m6").innerHTML = "￥";
		}

		if (st[0][st[0].length - 5] != undefined) {
			document.getElementById("m7").innerHTML = st[0][st[0].length - 5];
		} else if (st[0][st[0].length - 4] != undefined
				&& document.getElementById("m8").innerHTML == "") {
			document.getElementById("m7").innerHTML = "￥";
		}
		if (st[0][st[0].length - 6] != undefined) {
			document.getElementById("m8").innerHTML = st[0][st[0].length - 6];
		} else if (st[0][st[0].length - 5] != undefined
				&& document.getElementById("m9").innerHTML == "") {
			document.getElementById("m8").innerHTML = "￥";
		}
		if (st[0][st[0].length - 7] != undefined) {
			document.getElementById("m9").innerHTML = st[0][st[0].length - 7];
		} else if (st[0][st[0].length - 6] != undefined
				&& document.getElementById("m10").innerHTML == "") {
			document.getElementById("m9").innerHTML = "￥";
		}
		if (st[0][st[0].length - 8] != undefined) {
			document.getElementById("m10").innerHTML = st[0][st[0].length - 8];
		} else if (st[0][st[0].length - 7] != undefined
				&& document.getElementById("m11").innerHTML == "") {
			document.getElementById("m10").innerHTML = "￥";
		}

		if (st[0][st[0].length - 9] != undefined) {
			document.getElementById("m11").innerHTML = st[0][st[0].length - 9];
		} else if (st[0][st[0].length - 8] != undefined) {
			document.getElementById("m11").innerHTML = "￥";
		}
	}
	if (c == -1) {
		document.getElementById("m1").innerHTML = 0;
		document.getElementById("m2").innerHTML = 0;

		if (s[s.length - 1] != undefined) {
			document.getElementById("m3").innerHTML = s[s.length - 1];
		} else if (document.getElementById("m2").innerHTML == 0) {
			document.getElementById("m3").innerHTML = "￥";
		}

		if (s[s.length - 2] != undefined) {
			document.getElementById("m4").innerHTML = s[s.length - 2];
		} else if (s[s.length - 1] != undefined
				&& document.getElementById("m5").innerHTML == "") {
			document.getElementById("m4").innerHTML = "￥";
		}

		if (s[s.length - 3] != undefined) {
			document.getElementById("m5").innerHTML = s[s.length - 3];
		} else if (s[s.length - 2] != undefined
				&& document.getElementById("m6").innerHTML == "") {
			document.getElementById("m5").innerHTML = "￥";
		}

		if (s[s.length - 4] != undefined) {
			document.getElementById("m6").innerHTML = s[s.length - 4];
		} else if (s[s.length - 3] != undefined
				&& document.getElementById("m7").innerHTML == "") {
			document.getElementById("m6").innerHTML = "￥";
		}

		if (s[s.length - 5] != undefined) {
			document.getElementById("m7").innerHTML = s[s.length - 5];
		} else if (s[s.length - 4] != undefined
				&& document.getElementById("m8").innerHTML == "") {
			document.getElementById("m7").innerHTML = "￥";
		}

		if (s[s.length - 6] != undefined) {
			document.getElementById("m8").innerHTML = s[s.length - 6];
		} else if (s[s.length - 5] != undefined
				&& document.getElementById("m9").innerHTML == "") {
			document.getElementById("m8").innerHTML = "￥";
		}

		if (s[s.length - 7] != undefined) {
			document.getElementById("m9").innerHTML = s[s.length - 7];
		} else if (s[s.length - 6] != undefined
				&& document.getElementById("m10").innerHTML == "") {
			document.getElementById("m9").innerHTML = "￥";
		}

		if (s[s.length - 8] != undefined) {
			document.getElementById("m10").innerHTML = s[s.length - 8];
		} else if (s[s.length - 7] != undefined
				&& document.getElementById("m11").innerHTML == "") {
			document.getElementById("m10").innerHTML = "￥";
		}

		if (s[s.length - 9] != undefined) {
			document.getElementById("m11").innerHTML = s[s.length - 9];
		} else if (s[s.length - 8] != undefined) {
			document.getElementById("m11").innerHTML = "￥";
		}
	}
}