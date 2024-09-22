import { CommonModule } from '@angular/common';
import { Soldier } from '../../models/soldier';
import { SoldierService } from './../../services/soldier.service';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RankFinderPipe } from '../../pipes/rank-finder.pipe';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RankFinderPipe
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  ///----------------------------FIELDS--------------------------------------------------------------
  soldiers: Soldier[] = [];
  newSoldier: Soldier = new Soldier();
  editSoldier: Soldier | null = null;
  selected: Soldier | null = null;
  viewPltData: boolean = false;
  acftAverage: number | null = null;
  numberOfSoldiers: number | null = null;
  rank: string | null = null;
  ///----------------------------CONSTRUCTOR and ngOnInit--------------------------------------------------------------

  constructor(
    private soldierService: SoldierService
  ){}

  ngOnInit(): void{
    this.reloadSoldiers();
  }

  ///----------------------------METHODS--------------------------------------------------------------

  reloadSoldiers(): void{
    this.soldierService.index().subscribe( {
      next:(soldierList) => {
        this.soldiers = soldierList;
        console.log(this.soldiers);
      },
      error: (fail) =>{
        console.error('HomeComponent.reloadSoldiers: error retrieving soldier list');
        console.error(fail);
      }
    } );
  }
  countSoldiers() : number{
    console.log(this.soldiers.length)
    this.numberOfSoldiers = this.soldiers.length;
    return this.soldiers.length;
  }

//Pending detail div with selected cave
displaySoldier(soldier : Soldier){
  console.log(soldier.firstName + " Clicked!!");
  this.selected = soldier;
}

//Complete:  form to create new cave
addSoldier(soldier : Soldier){
  this.soldierService.create(soldier).subscribe({
    next: (createdSoldier) => {
      this.reloadSoldiers();
      this.newSoldier = new Soldier();
    },
    error: (oopsy) => {
      console.error('Error creating Soldier: ');
      console.error(oopsy);
    }
  })
}

showList() : void{
  //this.selected=null;

  this.selected=null;
  this.viewPltData = false;
  this.rank=null;
}

deleteSoldier(id: number){
  this.soldierService.destroy(id).subscribe({
    next: (result) =>{
      this.newSoldier = new Soldier();
      this.reloadSoldiers();
    },
    error: (nojoy) =>{
      console.error("Error deleting Soldier");
      console.error(nojoy);
    }

  });
}

setEditSoldier(){
  this.editSoldier = Object.assign({}, this.selected);
}

updateSoldier(soldier : Soldier, setSelected: boolean = true){
  console.log(soldier);
  this.soldierService.update(soldier).subscribe({
    next: (updatedSoldier) =>{
      if(setSelected){
        this.selected = updatedSoldier;
      }
      this.editSoldier = null;
      this.reloadSoldiers();
    }
  })

}
showViewPlatoonData(){
  this.viewPltData=true;
  this.viewPlatoonData();
  this.countSoldiers();

}

viewPlatoonData(){
  this.soldierService.calcPltAcftAvg().subscribe({
    next: (average : number) =>{
      this.acftAverage=average;
      this.reloadSoldiers();
      console.log("acft average: "+this.acftAverage);
      console.log("EOKVOSDGKJOKDGJOSDGJLSKDJ!!!!!");
    },
    error: (nojoy) =>{
      console.error("Error deleting Soldier");
      console.error(nojoy);
    }
  })
}

showRank(rank: string){
  this.rank=rank;
}
//TODO update form
//TODO delete button - where? in list or detail view?
//TODO models for FormationType, CaveVisit, User

}
