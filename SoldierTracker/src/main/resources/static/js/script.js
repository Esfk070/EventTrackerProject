console.log('script.js loaded');

window.addEventListener('load', function(){
	console.log('DOM loaded');
	init();
});

function init(){
	loadAllSoldiers();
	
	document.createSoldierForm.create.addEventListener('click', function(event){
		event.preventDefault();
		let firstName = document.createSoldierForm.firstName.value;
		let lastName = document.createSoldierForm.lastName.value;
		let rank = document.createSoldierForm.rank.value;
		let description = document.createSoldierForm.description.value;
		let dod = document.createSoldierForm.dod.value;
		
		let soldierObject = {
			firstName: firstName,
			lastName: lastName,
			rank: rank,
			description: description,			
			dod: dod,
			}
		
		createSoldier(soldierObject);
	})
	//TODO = event listeners, etc
}

function loadAllSoldiers(){
	let xhr = new XMLHttpRequest();
	xhr.open('GET',"api/soldiers");
	xhr.onreadystatechange = function(){
		if(xhr.readyState === xhr.DONE){
			if(xhr.status === 200){
				let soldiers = JSON.parse(xhr.responseText);
				console.log(soldiers.length);
				displaySoldiersList(soldiers);
			}
			else{
				//FIXME
			}
		}
	};
	xhr.send();
}


//soldiersTableDiv
function displaySoldiersList(soldiers){
	
	//FIXME
	console.log('displaySoldiersList called');
	
	let soldiersTableDiv = document.getElementById('soldiersTableDiv');
	soldiersTableDiv.textContent = '';
	
	//Table
	let table = document.createElement('table');
	table.textContent = '';
	soldiersTableDiv.appendChild(table);
	
	//headers
	let headRank = document.createElement('th');
	headRank.textContent = 'Rank';
	table.append(headRank)
	
	let head1 = document.createElement('th');
	head1.textContent = 'First Name';
	table.append(head1);
	
	let head2 = document.createElement('th');
	head2.textContent = 'Last Name';
	table.append(head2);
	

	
	//Table Rows
	for(let soldier of soldiers){
		console.log(soldier.firstName);
		
		let row = document.createElement('tr');
		
		let colRank = document.createElement('td');
		colRank.textContent = soldier.rank;
		row.append(colRank);
		
		let colFname = document.createElement('td');
		colFname.textContent = soldier.firstName;
		row.append(colFname);
		
		let colLname = document.createElement('td');
		colLname.textContent = soldier.lastName;
		row.append(colLname);
		
		table.append(row);
		
	}
}


function createSoldier(soldierObject){
	console.log(soldierObject);
	
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/soldier');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === xhr.DONE){
			if(xhr.status === 200  || xhr.status === 201){
				displaySoldier(JSON.parse(xhr.responseText));
				loadAllSoldiers();
			}
			else{
				displayError("Error creating soldier: " + xhr.status);
			}
		}
	};
	xhr.setRequestHeader("Content-type", "application/json");
	let soldierJson = JSON.stringify(soldierObject);
	xhr.send(soldierJson);
};

function displaySoldier(soldier){
	let addNewSoldierDiv =  document.getElementById('addNewSoldierDiv');
	addNewSoldierDiv.textContent='';
	//Soldier name
	let h1 = document.createElement('h1');
	h1.textContent = soldier.rank + " " + soldier.lastName + ", " + soldier.firstName;
	addNewSoldierDiv.appendChild(h1);
	//Soldier details
	let ul = document.createElement('ul');
	addNewSoldierDiv.appendChild(ul);
	
	let li = document.createElement('li');
	li.textContent = 'Description:' + soldier.description;
	ul.appendChild(li);

	li = document.createElement('li');
	li.textContent = 'DOD:' + soldier.dod;
	ul.appendChild(li);	

	li = document.createElement('li');
	li.textContent = 'Profile:' + soldier.profile;
	ul.appendChild(li);		


	
	
}


