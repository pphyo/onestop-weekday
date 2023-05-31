import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputChildComponent } from './input-child/input-child.component';

@Component({
  selector: 'app-input',
  standalone: true,
  imports: [CommonModule, InputChildComponent],
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})
export class InputComponent {

  courses = [
    {id: 1, name: 'Java Basic', fees: 300000, duration: 4},
    {id: 2, name: 'Spring Framework', fees: 500000, duration: 5},
    {id: 3, name: 'Angular Framework', fees: 400000, duration: 5},
    {id: 4, name: 'Onestop', fees: 750000, duration: 6},
    {id: 5, name: 'Cloud Foundation', fees: 400000, duration: 4}
  ]

}
