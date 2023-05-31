import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputViewChildComponent } from './input-view-child/input-view-child.component';

@Component({
  selector: 'app-input-view',
  standalone: true,
  imports: [CommonModule, InputViewChildComponent],
  templateUrl: './input-view.component.html'
})
export class InputViewComponent {

  @ViewChild(InputViewChildComponent)
  child:any

  add(data:string) {
    this.child.list.push(data)
  }

}
