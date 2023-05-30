import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-two',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './two.component.html',
  styleUrls: ['./two.component.css']
})
export class TwoComponent {

  text:any

  text2:any

}
