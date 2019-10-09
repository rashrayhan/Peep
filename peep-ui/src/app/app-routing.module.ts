import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TimelineComponent } from './timeline/timeline.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';



const routes: Routes = [
  {path: '', redirectTo:'/auth', pathMatch:'full' },
  {path: 'auth', component: AuthenticateComponent},
  {path: 'timeline', component: TimelineComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [AuthenticateComponent, TimelineComponent];
