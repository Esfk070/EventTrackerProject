import { CommonModule } from '@angular/common';
import { Soldier } from '../../models/soldier';
import { SoldierService } from './../../services/soldier.service';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  ///----------------------------FIELDS--------------------------------------------------------------
  soldiers: Soldier[] = [];
  newSoldier: Soldier = new Soldier();
  editSoldier: Soldier | null = null
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
      },
      error: (fail) =>{
        console.error('HomeComponent.reloadSoldiers: error retrieving soldier list');
        console.error(fail);
      }
    } );
  }

//TODO detail div with selected cave
//PENDING:  form to create new cave
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

//TODO update form
//TODO delete button - where? in list or detail view?
//TODO models for FormationType, CaveVisit, User

}
