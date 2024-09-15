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
		let imageUrl = document.createSoldierForm.imageUrl.value;
		
		let soldierObject = {
			firstName: firstName,
			lastName: lastName,
			rank: rank,
			description: description,			
			dod: dod,
			imageUrl: imageUrl
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
		
		//Click row
		row.addEventListener('click', function(){
			

			displaySoldier(soldier);
		})
		table.append(row);
		////NEXT user story is to get the soldiers information to pop up when they are called
	}
}


function createSoldier(soldierObject){
	
	
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

	
	let soldierId = soldier.id;
	
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
	
	//Display Image of soldier
	let img = document.createElement('img');
	img.src = soldier.imageUrl;
	addNewSoldierDiv.appendChild(img);
	
	//-----------Edit Button-------------------------------------------
	let editButton = document.createElement('button');
	addNewSoldierDiv.appendChild(editButton);
	editButton.textContent = 'Edit Soldier';
	
	
	
	

	editButton.addEventListener('click',function(){
		let editForm = document.createElement('form');
		addNewSoldierDiv.appendChild(editForm);
		editForm.id = 'editForm';
		

		editForm.innerHTML = `
		<label for="firstName">First Name</label><br>
		<input type="text" name="firstName" value="${soldier.firstName}"><br>

		<label for="lastName">Last Name</label><br>
		<input type="text" name="lastName" value="${soldier.lastName}"><br>	

		<label for="rank">Rank</label><br>
		<input type="text" name="rank" value="${soldier.rank}"><br>	

		<label for="description">Description</label><br>
		<textarea name="description" rows="4" cols="40">${soldier.description}</textarea><br>

		<label for="dod">DOD</label><br>
		<input type="number" name="dod" value="${soldier.dod}"><br>

		<label for="imageUrl">Image URL</label><br>
		<input type="text" name="imageUrl" value="${soldier.imageUrl}"><br>			
					
		<button type = "button" id = "saveChangesButton">Save Changes</button>
		
		`;
		
	


		let saveButton = document.getElementById('saveChangesButton');
		//-----------Save Changes-------------------------------------------
		saveButton.addEventListener('click', function(){
			console.log("IS THIS BUTTON EVEN WORKING!!!!!!!");
	
			let firstName = editForm.firstName.value;
			let lastName = editForm.lastName.value;
			let rank = editForm.rank.value;
			let description = editForm.description.value;
			let dod = editForm.dod.value;
			let imageUrl = editForm.imageUrl.value;
			
			let soldierObj = {
				firstName: firstName,
				lastName: lastName,
				rank: rank,
				description: description,
				dod: dod,
				imageUrl: imageUrl 
				
						
			};

			editSoldier(soldierObj, soldierId);

		
		
	});
	
});









}



function editSoldier(soldierObject, soldierId){
	
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', `api/soldier/${soldierId}`);
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
	let soldierJson = JSON.stringify(soldierObject, soldierId);
	xhr.send(soldierJson);
};

