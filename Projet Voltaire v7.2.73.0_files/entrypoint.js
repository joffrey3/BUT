function loadGwtModule(module) {
	var fingerprint = ("202110071441" == "${maven_build" + "_timestamp}") ? (Math.random() * 431858459348539458) : "202110071441";
	var url = module + "?" + fingerprint;
	document.write('<script type="text/javascript" src="' + url + '"></script>');
}