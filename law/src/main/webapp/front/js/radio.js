// JavaScript Document    
var time = window.setInterval("show()", 2000);
var index = 1;

function show(id) {
	if (id) {
		index = id;
		clearInterval(time);
	} else {
		index = index % 5 + 1;
	}
	// 设置图片
	document.getElementById('pic').style.backgroundImage = 'url(images/lunbo'
			+ index + '.jpg)';
	var ul = document.getElementById('scroll_number');
	var lis = ul.getElementsByTagName('li');
	for (var i = 0; i < lis.length; i++) {
		lis[i].style.background = '#D6D6D6';
		if (i == index - 1) {
			lis[i].style.background = '#9D9D9D';
		}
	}
}
function start() {
	time = window.setInterval("show()", 2000)
}
