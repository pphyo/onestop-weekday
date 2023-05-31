import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { InputComponent } from './app/input/input.component';
import { LocalComponent } from './app/local/local.component';
import { InputViewComponent } from './app/input-view/input-view.component';
import { UsingListenerComponent } from './app/using-listener/using-listener.component';
import { UsingObservableComponent } from './app/using-observable/using-observable.component';
import { UsingOutputComponent } from './app/using-output/using-output.component';

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter([
      {path: 'input', component: InputComponent},
      {path: 'local', component: LocalComponent},
      {path: 'view', component: InputViewComponent},
      {path: 'listener', component: UsingListenerComponent},
      {path: 'observable', component: UsingObservableComponent},
      {path: 'output', component: UsingOutputComponent},
      {path: '', pathMatch: 'full', redirectTo: '/input'}
    ])
  ]
})
  .catch((err) => console.error(err));
