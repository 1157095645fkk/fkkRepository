
// ---------- 通用function----------
function dangerChar(str,id) {
	var resultTag = 0;
	var flag = 0;
	var pattern = /[`~!@#\$%\^\&\*\(\)_\+<>\?:"\{\},\.\\\/;'\[\]]/im;
	if (pattern.test(str)) {
		resultTag = resultTag + 1;
	}
}





