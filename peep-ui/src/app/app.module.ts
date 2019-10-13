import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AlertModule } from 'ngx-bootstrap';
import {MatFormFieldModule, MatInputModule, MatButtonModule, MatIconModule, MatListModule, MatTabsModule} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
import { AuthenticateComponent } from './pages/authenticate/authenticate.component';
import { FollowingComponent } from './pages/following/following.component';
import { UserComponent } from './pages/user/user.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { DialogpeepComponent } from './pages/dialogpeep/dialogpeep.component';
import { ProfiledialogComponent } from './pages/profiledialog/profiledialog.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    AuthenticateComponent,
    FollowingComponent,
    UserComponent,
    ProfileComponent,
    DialogpeepComponent,
    ProfiledialogComponent,
  ],
  imports: [
    AlertModule.forRoot(),
    ReactiveFormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    BrowserModule,
    AppRoutingModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatListModule,
    MatTabsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
