import { Component, Inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComponentService } from '../services/using-component.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-using-component',
  standalone: true,
  imports: [CommonModule, RouterModule],
  providers: [
    {provide: ComponentService, useClass: ComponentService},
    {provide: "locale", useValue: "en-US"}
  ],
  templateUrl: './using-component.component.html'
})
export class UsingComponentComponent implements OnInit {

  list:any = []

  constructor(private service:ComponentService,
    @Inject("locale") public locale:string) {}

  ngOnInit(): void {
    this.search(0)
  }

  search(param:any) {
    if(param)
      return this.list = [this.service.findById(param)]

    return this.list = this.service.getAll()
  }

}
