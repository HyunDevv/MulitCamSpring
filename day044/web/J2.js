/**
 * 
 */

var i = 100;
var i = 200;
alert('Start'+i);
window.onload = function(){
	document.querySelector('h2').innerHTML='Start.......' //body가 다출력된 이후에 실행된다	
};


function myFunction() {
	var data = 10;
	//alert('OK:'+ data);
	console.log('OK:'+ data);
//	document.getElementById("demo").innerHTML =
//	 "Paragraph changed.";
	document.querySelector('#demo').innerHTML = 'Changed';
};
