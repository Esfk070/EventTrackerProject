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

}
