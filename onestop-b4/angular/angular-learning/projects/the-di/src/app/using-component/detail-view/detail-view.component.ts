import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ComponentService } from '../../services/using-component.service';

@Component({
  selector: 'app-detail-view',
  standalone: true,
  imports: [CommonModule, RouterModule],
  providers: [
    {provide: ComponentService, useClass: ComponentService}
  ],
  templateUrl: './detail-view.component.html'
})
export class DetailViewComponent implements OnInit {

  targetData:any

  constructor(private service:ComponentService, private route:ActivatedRoute) {
    this.route.paramMap.subscribe(param => {
      const id = Number.parseInt(param.get('id') as string)
      this.targetData = this.service.findById(id);
    })
  }

  ngOnInit(): void {

  }

}
