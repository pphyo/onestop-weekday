import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsingListenerChildComponent } from './using-listener-child/using-listener-child.component';

export interface StringValueListener {
  take(value:string):void
}

@Component({
  selector: 'app-using-listener',
  standalone: true,
  imports: [CommonModule, UsingListenerChildComponent],
  templateUrl: './using-listener.component.html'
})
export class UsingListenerComponent {

  list:any = []

  parentListener:any

  constructor() {
    this.parentListener = this
  }

  take(value: string) {
    this.list.push(value)
  }

}
