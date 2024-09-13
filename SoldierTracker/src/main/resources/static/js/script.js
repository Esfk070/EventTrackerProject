console.log('script.js loaded');

window.addEventListener('load', function(){
	console.log('DOM loaded');
	init();
});

function init(){
	loadAllSoldiers();
	
	//TODO = event listeners, etc
}

function loadAllSoldiers(){
	let xhr = new XMLHttpRequest();
	xhr.open('GET',"api/soldiers");
	xhr.onreadystatechange = function(){
		if(xhr.readyState === xhr.DONE){
			if(xhr.status === 200){
				let soldiers = JSON.parse(xhr.responseText);
				console.log(soldiers);
				displaySoldiersList(soldiers);
			}
			else{
				//FIXME
			}
		}
	};
	xhr.send();
}

function displaySoldiersList(soldiers){
	//FIXME
	console.log('displaySoldiersList called');
}

