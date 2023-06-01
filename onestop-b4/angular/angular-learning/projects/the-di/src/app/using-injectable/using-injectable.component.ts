import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InjectorService } from '../services/using-injector.service';

@Component({
  selector: 'app-using-injectable',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './using-injectable.component.html'
})
export class UsingInjectableComponent implements OnInit {

  list:any = []

  constructor(private service:InjectorService) {}

  ngOnInit(): void {
    this.search(0)
  }

  search(param:any) {
    if(param)
      return this.list = [this.service.findById(param)]

    return this.list = this.service.getAll()
  }

}
