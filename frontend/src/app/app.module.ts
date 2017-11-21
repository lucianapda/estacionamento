<<<<<<< HEAD
import 'hammerjs';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BsDropdownModule } from 'ngx-bootstrap';
import { RouterModule, Routes } from '@angular/router';
import { AlertModule } from 'ngx-bootstrap';
import {
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatStepperModule
} from '@angular/material';
import { AppComponent } from './app.component';
import { CadastroUsuarioComponent } from './cadastro-usuario/cadastro-usuario.component';
import { ServicoUsuarioService } from './cadastro-usuario/servico-usuario.service';
import { BairroService } from './models/bairro.service';
import { LoginDialogComponent } from './login-dialog/login-dialog.component';
import { CadastroVagaComponent } from './cadastro-vaga/cadastro-vaga.component';
import { CdkTableModule } from '@angular/cdk/table';
import { MainScreenComponent } from './main-screen/main-screen.component';
import { ImageListComponent } from './main-screen/image-list/image-list.component';
import { ImageComponent } from './main-screen/image-list/image.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CurrencyMaskModule } from "ng2-currency-mask";
import { InformationComponent } from './information/information.component';
import { SlideListComponent } from './information/slide-list/slide-list.component';
import { SlideComponent } from './information/slide-list/slide.component';
import { FinancialMovementComponent } from './financial-movement/financial-movement.component';
import { ScreenHomeComponent } from './screen-home/screen-home.component';
import { ServicoEstacionamentoService } from './information/servico-estacionamento.service';
import { CarouselModule } from 'ngx-bootstrap';
import { CadastroEstacionamentoComponent } from './cadastro-estacionamento/cadastro-estacionamento.component'
import { EstacionamentoService } from './cadastro-estacionamento/estacionamento.service';
const appRoutes: Routes = [
  { path: 'new_user', component: CadastroUsuarioComponent },
   { path: 'parking', component: InformationComponent},
   { path: '', component: ScreenHomeComponent}
 ];

@NgModule({
  declarations: [
    AppComponent,
    CadastroUsuarioComponent,
    MainScreenComponent,
    ImageListComponent,
    ImageComponent,
    HeaderComponent,
    FooterComponent,
    LoginDialogComponent,
    CadastroVagaComponent,
    InformationComponent,
    SlideListComponent,
    SlideComponent,
    FinancialMovementComponent,
    ScreenHomeComponent,
    CadastroEstacionamentoComponent    
  ],

  imports: [
     RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } 
    ),
    CarouselModule.forRoot(),
    AlertModule.forRoot(),
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    CdkTableModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    BsDropdownModule.forRoot(),
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    CurrencyMaskModule
  ],
  entryComponents: [
    LoginDialogComponent
  ],
  providers: [
    ServicoUsuarioService, 
    ServicoEstacionamentoService,
    BairroService, 
    EstacionamentoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
=======
import 'hammerjs';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BsDropdownModule } from 'ngx-bootstrap';
import { RouterModule, Routes } from '@angular/router';
import { AlertModule } from 'ngx-bootstrap';
import {
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatStepperModule
} from '@angular/material';
import { AppComponent } from './app.component';
import { CadastroUsuarioComponent } from './cadastro-usuario/cadastro-usuario.component';
import { ServicoUsuarioService } from './cadastro-usuario/servico-usuario.service';
import {BairroService} from './models/bairro.service';
import {CidadeService} from './models/cidade.service';
import { LoginDialogComponent } from './login-dialog/login-dialog.component';
import { CadastroVagaComponent } from './cadastro-vaga/cadastro-vaga.component';
import { CdkTableModule } from '@angular/cdk/table';
import { MainScreenComponent } from './main-screen/main-screen.component';
import { ImageListComponent } from './main-screen/image-list/image-list.component';
import { ImageComponent } from './main-screen/image-list/image.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CurrencyMaskModule } from "ng2-currency-mask";
import { InformationComponent } from './information/information.component';
import { SlideListComponent } from './information/slide-list/slide-list.component';
import { SlideComponent } from './information/slide-list/slide.component';
import { FinancialMovementComponent } from './financial-movement/financial-movement.component';
import { ScreenHomeComponent } from './screen-home/screen-home.component';
import { ServicoEstacionamentoService } from './information/servico-estacionamento.service';
import { CarouselModule } from 'ngx-bootstrap';

const appRoutes: Routes = [
  { path: 'new_user', component: CadastroUsuarioComponent },
   { path: 'parking', component: InformationComponent},
   { path: '', component: ScreenHomeComponent}
 ];

@NgModule({
  declarations: [
    AppComponent,
    CadastroUsuarioComponent,
    MainScreenComponent,
    ImageListComponent,
    ImageComponent,
    HeaderComponent,
    FooterComponent,
    LoginDialogComponent,
    CadastroVagaComponent,
    InformationComponent,
    SlideListComponent,
    SlideComponent,
    FinancialMovementComponent,
    ScreenHomeComponent
  ],

  imports: [
     RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } 
    ),
    CarouselModule.forRoot(),
    AlertModule.forRoot(),
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    CdkTableModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    BsDropdownModule.forRoot(),
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    CurrencyMaskModule
  ],
  entryComponents: [
    LoginDialogComponent
  ],
  providers: [ServicoUsuarioService, ServicoEstacionamentoService, BairroService, CidadeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
>>>>>>> ded136097285f425083149fc15cc21740c58c7be
