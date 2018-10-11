var key = 'BOTWAVEE';
// CBC模式加密
function encryptByDESModeCBC(message) {
	var keyHex = CryptoJS.enc.Utf8.parse(key);
	var ivHex = CryptoJS.enc.Utf8.parse(key);
	encrypted = CryptoJS.DES.encrypt(message, keyHex, {
		iv : ivHex,
		mode : CryptoJS.mode.CBC,
		padding : CryptoJS.pad.Pkcs7
	});
	return encrypted.ciphertext.toString();
}
// CBC模式解密
function decryptByDESModeCBC(ciphertext2) {
	var keyHex = CryptoJS.enc.Utf8.parse(key);
	var ivHex = CryptoJS.enc.Utf8.parse(key);
	// direct decrypt ciphertext
	var decrypted = CryptoJS.DES.decrypt({
		ciphertext : CryptoJS.enc.Hex.parse(ciphertext2)
	}, keyHex, {
		iv : ivHex,
		mode : CryptoJS.mode.CBC,
		padding : CryptoJS.pad.Pkcs7
	});
	return decrypted.toString(CryptoJS.enc.Utf8);
}
// DES ECB模式加密
function encryptByDESModeEBC(message) {
	var keyHex = CryptoJS.enc.Utf8.parse(key);
	var encrypted = CryptoJS.DES.encrypt(message, keyHex, {
		mode : CryptoJS.mode.ECB,
		padding : CryptoJS.pad.Pkcs7
	});
	return encrypted.ciphertext.toString();
}
// DES ECB模式解密
function decryptByDESModeEBC(ciphertext) {
	var keyHex = CryptoJS.enc.Utf8.parse(key);
	var decrypted = CryptoJS.DES.decrypt({
		ciphertext : CryptoJS.enc.Hex.parse(ciphertext)
	}, keyHex, {
		mode : CryptoJS.mode.ECB,
		padding : CryptoJS.pad.Pkcs7
	});
	var result_value = decrypted.toString(CryptoJS.enc.Utf8);
	return result_value;
}
/*
 * function test() { var source = $("#source").val(); var cc =
 * encryptByDESModeEBC(CryptoJS.enc.Utf8.parse(source)); $("#target").val(cc); }
 * function test1() { var source = $("#sourceS").val(); var dd =
 * decryptByDESModeEBC(source); $("#jiemi").val(dd); }
 */

/*var data = "888888";
var srcs = CryptoJS.enc.Utf8.parse(data);
var key = CryptoJS.enc.Utf8.parse('o7H8uIM2O5qv65l2');// Latin1 w8m31+Yy/Nw6thPsMpO5fg==
*/

/*function Encrypt(word, key) {
	var keys = CryptoJS.enc.Utf8.parse(key);
	var srcs = CryptoJS.enc.Utf8.stringify(word);
	var encrypted = CryptoJS.AES.encrypt(srcs, keys, {
		iv: CryptoJS.enc.Utf8.parse(key),
		mode : CryptoJS.mode.ECB,
		padding : CryptoJS.pad.Pkcs7
	});
	return encrypted.toString();
}*/

/*function Decrypt(word, key) {

	var decrypt = CryptoJS.AES.decrypt(word, key, {
		mode : CryptoJS.mode.ECB,
		padding : CryptoJS.pad.Pkcs7
	});
	return CryptoJS.enc.Utf8.stringify(decrypt).toString();
}*/


/**
 * AES加密
 */
function encrypt (msg, key, iv) {
	var key =    CryptoJS.enc.Base64.parse(key);
    var iv =    CryptoJS.enc.Base64.parse(iv);
    return  CryptoJS.AES.encrypt(msg,  key, {
        iv: iv,
        padding: CryptoJS.pad.Pkcs7,
        mode: CryptoJS.mode.CBC
    });
}

/**
 * AES解密
 */
function decrypt (cipherText, key, iv) {
    return  CryptoJS.AES.decrypt({ ciphertext: cipherText }, key, {
        iv: iv,
        padding: CryptoJS.pad.Pkcs7,
        mode: CryptoJS.mode.CBC

    });
}