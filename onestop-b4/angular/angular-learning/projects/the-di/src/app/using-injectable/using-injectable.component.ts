import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InjectorService } from '../services/using-injector.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-using-injectable',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './using-injectable.component.html'
})
export class UsingInjectableComponent implements OnInit {

  list:any = []

  constructor(private service:InjectorService, private router:Router) {}

  ngOnInit(): void {
    this.search(0)
  }

  navigate(id:number) {
    this.router.navigate(['/inject/view'], {queryParams: {'id': id}})
  }

  search(param:any) {
    if(param)
      return this.list = [this.service.findById(param)]

    return this.list = this.service.getAll()
  }

}
