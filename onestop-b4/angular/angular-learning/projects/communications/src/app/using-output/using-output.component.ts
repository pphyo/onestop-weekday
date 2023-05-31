import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsingOutputChildComponent } from './using-output-child/using-output-child.component';

@Component({
  selector: 'app-using-output',
  standalone: true,
  imports: [CommonModule, UsingOutputChildComponent],
  templateUrl: './using-output.component.html'
})
export class UsingOutputComponent {

  list:any = []

  load(data:string) {
    this.list.push(data)
  }

}
