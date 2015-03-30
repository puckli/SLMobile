// 把数字金额转换为(中文大写)金额.
function convertCurrency(currencyDigits) {

	var MAXIMUM_NUMBER = 999999999.99;
	var CN_ZERO = "零";
	var CN_ONE = "壹";
	var CN_TWO = "贰";
	var CN_THREE = "叁";
	var CN_FOUR = "肆";
	var CN_FIVE = "伍";
	var CN_SIX = "陆";
	var CN_SEVEN = "柒";
	var CN_EIGHT = "捌";
	var CN_NINE = "玖";
	var CN_TEN = "拾";
	var CN_HUNDRED = "佰";
	var CN_THOUSAND = "仟";
	var CN_TEN_THOUSAND = "万";
	var CN_HUNDRED_MILLION = "亿";
	var CN_DOLLAR = "元";
	var CN_TEN_CENT = "角";
	var CN_CENT = "分";
	var CN_INTEGER = "整";

	var integral;
	var decimal;
	var outputCharacters;
	var parts;
	var digits, radices, bigRadices, decimals;
	var zeroCount;
	var i, p, d;
	var quotient, modulus;

	/*
	 * // 验证是否为数字 if (currencyDigits.match(/[^,.\d]/) != null) {
	 * alert("输入内容不能包含字符串!"); return ""; } // 验证输入内容 if
	 * ((currencyDigits).match(/^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/) ==
	 * null) { alert("输入内容不合法!"); return ""; }
	 */

	currencyDigits = currencyDigits.replace(/,/g, "");
	/* currencyDigits = currencyDigits.replace(/^0+/, ""); */
	// 如果是数字就是false，否则就不是数字就是true
	var tempStr = currencyDigits.substring(0, 1) + "n";
	if (currencyDigits != ""
			&& currencyDigits != "￥"
			&& !currencyDigits
					.match(/^([￥]{0,1})([1-9][\d]{0,8}|0)(\.[\d]{0,2})?$/)) {
		alert("您输入的金额不合法");
		return;
	}
	if (currencyDigits.match(/^([￥]{1,1})([1-9][\d]{0,8}|0)(\.[\d]{0,2})?$/)) {
		currencyDigits = currencyDigits.substring(1, currencyDigits.length);
	}

	if (Number(currencyDigits) > MAXIMUM_NUMBER) {
		alert("输入的数字过大!");
		return "";
	}

	parts = currencyDigits.split(".");
	if (parts.length > 1) {
		integral = parts[0];
		decimal = parts[1];

		decimal = decimal.substr(0, 2);
	} else {
		integral = parts[0];
		decimal = "";
	}

	digits = new Array(CN_ZERO, CN_ONE, CN_TWO, CN_THREE, CN_FOUR, CN_FIVE,
			CN_SIX, CN_SEVEN, CN_EIGHT, CN_NINE);
	radices = new Array("", CN_TEN, CN_HUNDRED, CN_THOUSAND);
	bigRadices = new Array("", CN_TEN_THOUSAND, CN_HUNDRED_MILLION);
	decimals = new Array(CN_TEN_CENT, CN_CENT);

	outputCharacters = "";

	if (Number(integral) > 0) {
		zeroCount = 0;
		for (i = 0; i < integral.length; i++) {
			p = integral.length - i - 1;
			d = integral.substr(i, 1);
			quotient = p / 4;
			modulus = p % 4;
			if (d == "0") {
				zeroCount++;
			} else {
				if (zeroCount > 0) {
					outputCharacters += digits[0];
				}
				zeroCount = 0;
				outputCharacters += digits[Number(d)] + radices[modulus];
			}
			if (modulus == 0 && zeroCount < 4) {
				outputCharacters += bigRadices[quotient];
			}
		}
		outputCharacters += CN_DOLLAR;
	}

	if (decimal != "") {
		// 角
		jiao = decimal.substr(0, 1);
		// 分
		fen = decimal.substr(1, 2);

		if (jiao == "0" && fen != "0") {
			outputCharacters += digits[Number(0)];
		}
		if (jiao != "0") {
			outputCharacters += digits[Number(jiao)] + CN_TEN_CENT;
		}

		if (fen == "0" && jiao != "0") {
			outputCharacters += CN_INTEGER;
		}
		if (fen != "0") {
			outputCharacters += digits[Number(fen)] + CN_CENT;
		}
		if (jiao == "0" && fen == "0") {
			outputCharacters += CN_INTEGER;
		}
	}

	if (outputCharacters == "") {
		outputCharacters = CN_ZERO + CN_DOLLAR;
	}
	if (decimal == "") {
		outputCharacters += CN_INTEGER;
	}
	outputCharacters = outputCharacters;

	// 对应的小写
	symbol(currencyDigits);

	document.getElementById("moneyok").value = outputCharacters;

	document.getElementById("moneyok").innerHTML = outputCharacters;
}
