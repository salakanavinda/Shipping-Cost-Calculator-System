import { Component, OnInit } from '@angular/core';
import { Method } from 'src/app/entity/method';
import { Item } from 'src/app/entity/item';
import { Weight } from 'src/app/entity/weight';
import { Country } from 'src/app/entity/country';
import { Service } from 'src/app/entity/service';
import { Rate } from 'src/app/entity/rate';
import { ServiceRate } from 'src/app/entity/serviceRate';
import { RateServiceService } from 'src/app/service/rate-service.service';
import { ContryServiceService } from 'src/app/service/contry-service.service';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  methodList: Method [] = [];
  itemList: Item [] = [];
  countryList: string [];
  serviceList: Service [] = [];
  subServiceList: Service [] = [];
  quotation: number = 0.00;


  rate: Rate = new Rate;
  serviceRate: ServiceRate = new ServiceRate;

  itemCheck: boolean = false;
  weightCheck: boolean = false;
  countryCheck: boolean = false;
  serviceCheck: boolean = false;
  subServiceCheck: boolean = false;
  gOrKg: string = "";
  
  itemError: boolean =false;
  weightEnter:boolean = false;

  selectedMethod: number;
  selectedItem: number;
  inputWeight: number;
  selectedCountry: string;
  selectedService: number;
  selectedSubService: number;

  config = {
    displayKey:"description", //if objects array passed which key to be displayed defaults to description
    search:true, //true/false for the search functionlity defaults to false,
    height: 'auto', //height of the list so that if there are more no of items it can show a scroll defaults to auto. With auto height scroll will never appear
    placeholder:'Select destination country', // text to be displayed when no item is selected defaults to Select,
    customComparator: ()=>{}, // a custom function using which user wants to sort the items. default is undefined and Array.sort() will be used in that case,
    //limitTo: 0, // a number thats limits the no of options displayed in the UI similar to angular's limitTo pipe
    moreText: 'more', // text to be displayed whenmore than one items are selected like Option 1 + 5 more
    noResultsFound: 'No results found!', // text to be displayed when no items are found while searching
    searchPlaceholder:'Search destination country', // label thats displayed in search input,
    searchOnKey:'name' // key on which search should be performed this will be selective search. if undefined this will be extensive search on all keys
    }

  constructor(private rateService:RateServiceService,private countryService:ContryServiceService) { }

  ngOnInit() {
    this.resetForm();
    this.getMethodList();
  }

  resetForm(){
    (<HTMLFormElement>document.getElementById("calcForm")).reset();
    this.countryList = [];
    this.inputWeight = 0.00;
  }

  resetCountrySelect(){
    // console.log("selecting country");
    // (<HTMLFormElement>document.getElementById("selectCountry")).value = null;
  }

  resetFormFields(){
    (<HTMLFormElement>document.getElementById("weightInput")).value = "";
    (<HTMLFormElement>document.getElementById("selectCountry")).value = null;
    this.selectedCountry = null;
    this.quotation = 0.00;
    this.itemCheck = false;
    this.weightCheck = false;
    this.countryCheck = false;
    this.serviceCheck = false;
    this.subServiceCheck = false;
    this.gOrKg = "";
    this.inputWeight = 0.00;
  }

  getMethodList(){
    this.methodList = [
      {id: 0, type: "Air Mail"},
      {id: 1, type: "Sea Mail"},
      {id: 2, type: "Expedited Mail Service(EMS)"},
      {id: 3, type: "Air Parcel"},
      {id: 4, type: "Sea Parcel"}
    ];
  }

  getItemsForAirMail(){
    this.itemList = [
      {id: 0, type: "Letter"},
      {id: 1, type: "Printed Matter"},
      {id: 2, type: "Post Cards"},
      {id: 3, type: "Aerogrammes"},
      {id: 4, type: "Small Packets"},
      {id: 5, type: "Service"}
    ];
    
  }

  getItemsForEMS(){
    this.itemList = [
      {id: 0, type: "Document"},
      {id: 1, type: "Merchandise"}
    ];
  }

  getItemsForSeaMail(){
    this.itemList = [
      {id: 0, type: "Letter"},
      {id: 1, type: "Printed Matter"},
      {id: 2, type: "Post Cards"},
      {id: 3, type: "Literature For the blind"},
      {id: 4, type: "Small Packets"},
      {id: 5, type: "Service"}
    ];
  }

  onMethodSelect(methodId: number){
    // console.log(methodId);
    this.resetFormFields();
    this.itemError = false;
    this.weightEnter =false;

    if(methodId == 0){//AirMail
      
      this.itemCheck = true; 
      this.weightCheck = true;  
      this.gOrKg = "in grams";   
      this.countryCheck = true;
      this.serviceCheck = false;
      this.subServiceCheck = false;
      this.getItemsForAirMail();
      this.getAirMailCountry();
      this.selectedMethod = methodId;
      this.selectedItem = null;

    }else if(methodId == 1){//SeaMail
      
      this.countryList = null;
      this.itemCheck = true;
      this.weightCheck = true;
      this.gOrKg = "in grams";
      this.countryCheck = false;
      this.serviceCheck = false;
      this.subServiceCheck = false;
      this.getItemsForSeaMail();
      this.selectedMethod = methodId;
      this.selectedItem = null;

    }else if(methodId == 2){//EMS
      
      this.itemCheck = true;   
      this.weightCheck = true; 
      this.gOrKg = "in kilograms";  
      this.countryCheck = true;
      this.serviceCheck = false;
      this.subServiceCheck = false;
      this.getItemsForEMS();
      this.getEMSCountry();
      this.selectedMethod = methodId;
      this.selectedItem = null;

    }else if(methodId == 3){//AirParcel
      (<HTMLFormElement>document.getElementById("selectItem")).value =null;
      this.itemCheck = false;
      this.weightCheck = true;
      this.gOrKg = "in kilograms";
      this.countryCheck = true;
      this.serviceCheck = false;
      this.subServiceCheck = false;
      this.getAirParcelCountry(); 
      this.selectedMethod = methodId;
      this.selectedItem = null;

    }else if(methodId == 4){//SeaParcel
      (<HTMLFormElement>document.getElementById("selectItem")).value =null;
      this.itemCheck = false;
      this.weightCheck = true;
      this.gOrKg = "in kilograms";
      this.countryCheck = true;
      this.serviceCheck = false;
      this.subServiceCheck = false;
      this.getSeaParcelCountry();
      this.selectedMethod = methodId;
      this.selectedItem = null;

    }else{
      //Else
      this.weightCheck = false;
      this.gOrKg = "";
      this.itemCheck = false;
      this.countryCheck = false;
      this.serviceCheck = false;
      this.subServiceCheck = false;
      this.resetForm();
      this.selectedMethod = null;
    }
  }

  onItemSelect(itemId: number){
    // console.log(itemId);
    this.itemError = false;

    if(itemId == 5){
      (<HTMLFormElement>document.getElementById("weightInput")).value = "";
      
      this.countryCheck = false;
      this.serviceCheck = true;
      this.weightCheck = false;
      this.getServiceList(); 
      this.selectedItem = itemId; 
      this.inputWeight =0.00;
      this.quotation = 0;
    }else if(itemId == 3 || itemId == 2){
     
      this.weightCheck = false;
      this.serviceCheck = false;
      this.selectedItem = itemId;
      this.inputWeight =0.00;
      if(this.selectedMethod == 0){
        this.countryCheck = true;
      }else if(this.selectedMethod == 1){
        this.countryCheck = false;
      }
      
      //this.selectedCountry = null;
      (<HTMLFormElement>document.getElementById("weightInput")).value = "";
      if(this.selectedMethod == 0){
        if(this.selectedCountry !=undefined || this.selectedCountry !=null){
          this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
        }
      }else if(this.selectedMethod == 1){
        
          this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
        
      }
      //this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
      
    }else{
    
      if(this.selectedMethod == 1){
      this.countryCheck = false;
      }else{
        this.countryCheck = true;
      }
      this.weightCheck = true;
      this.serviceCheck = false;
      this.selectedItem = itemId;
      this.quotation = 0;
      if(this.selectedMethod == 1){
        if(this.inputWeight > 0){
          this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
        }
      }
      if(this.selectedCountry != null){
        if(this.inputWeight > 0){
            this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
        }
      }
    }
  }

  onWeightEnter(event){
    var input = (<HTMLFormElement>document.getElementById("weightInput")).value;
    
    this.weightEnter = false;

    var itemOk :boolean = true;

    if(this.selectedMethod == 1){
      if(this.selectedItem == null || this.selectedItem == undefined){
         this.itemError = true;
         itemOk = false;
      }else{
        this.itemError = false;
      }

    }

    if(input == ""){
      input = "0";
      this.quotation = 0.00;
    }
    input = +input;
    
    this.inputWeight = input;
    if(this.selectedMethod == 0){
      if(this.selectedItem != null || this.selectedItem != undefined){
        if(this.selectedCountry != null){
          if(input > 0){
            this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
          }
    
        }
      }
      
    }else if(this.selectedMethod == 1){
        if(this.selectedItem != null || this.selectedItem != undefined){
          if(input > 0){
            this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
          }
        }
      
    }else if(this.selectedMethod == 3 ||this.selectedMethod == 4){
      if(this.selectedCountry != null ){
      if(input > 0){
        this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
      }
     }
    }else if(this.selectedMethod == 2){

      if(this.selectedCountry != null ){
        if(this.selectedItem != null || this.selectedItem != undefined){

          if(input > 0){
            this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
          }
        }
       }
    }
    
  }

  onServiceSelect(serviceId: number){
    // console.log(serviceId);
    this.inputWeight = 0.00;
    if(serviceId == 11){
      this.quotation = 0.00;
      this.subServiceCheck = true;
      this.weightCheck = false;
      this.getSubServiceList(); 
      this.selectedService = serviceId;
    }else{
      this.weightCheck = false;
      this.subServiceCheck = false;
      this.selectedService = serviceId;
      this.getServiceRate(this.selectedMethod, this.selectedItem,this.selectedService,this.selectedSubService);
    }
  }

  onSubServiceSelect(subServiceId: number){
    // console.log(subServiceId);
    this.selectedSubService = subServiceId;
    this.getServiceRate(this.selectedMethod, this.selectedItem,this.selectedService,this.selectedSubService);
  }
  
  bypassSelect(event){
    if(event.type == "change" && event.isTrusted == true){

    }else{
      this.onCountrySelect(event.value);
    }
  }
  //Data pass to get rate on scenario without service
  onCountrySelect(country: string){
    
    this.selectedCountry = country;
    
    var itemOk :boolean = true;
    var weightOK :boolean =true;

    if(this.selectedMethod == 0 || this.selectedMethod == 2){
      if(this.selectedItem == null || this.selectedItem == undefined){
         this.itemError = true;
         itemOk = false;
      }else{
        this.itemError = false;
      }
      if(this.selectedItem == 2 || this.selectedItem == 3 || this.selectedItem == 5){
        this.weightEnter = false;
      }else{
        if(this.inputWeight <= 0){
           this.weightEnter = true;
           weightOK = false;
      }else{
        this.weightEnter = false;
      }
    }

    }else if(this.selectedMethod == 3 || this.selectedMethod == 4){
      if(this.inputWeight <= 0){
        this.weightEnter = true;
        weightOK = false;
      }else{
        this.weightEnter = false;
      }
    }
    console.log(this.selectedMethod+ this.selectedItem+ this.inputWeight+ this.selectedCountry);
    if(this.serviceCheck == false){
      //this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
      if(this.selectedMethod == 0 || this.selectedMethod == 2){
        if(this.inputWeight > 0 && (this.selectedItem !=null || this.selectedItem != undefined) && this.selectedCountry!=undefined){
          this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
        }else if((this.selectedItem == 2|| this.selectedItem == 3)&& this.selectedCountry!=undefined){
          this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
        }
      }else if(this.selectedMethod == 3 || this.selectedMethod == 4){
        if(this.inputWeight > 0){
          this.getRate(this.selectedMethod, this.selectedItem, this.inputWeight, this.selectedCountry);
        }
      }
      
    }else if(this.serviceCheck == true){
      //this.getServiceRate(this.selectedMethod,this.selectedItem,);
    }else{

    }
  }

  //Different Method Countries
  getAirMailCountry(){
    // this.countryList = [
    //   "Sri Lanka","India","China"
    // ]
    this.countryService.getAirMailCountry().subscribe(data=>{
       this.countryList = data
    });
  }

  getEMSCountry(){
    // this.countryList = [
    //   "USA","UK","Canada"
    // ]
    this.countryService.getEMSCountry().subscribe(data=>{
      this.countryList = data
    });
  }

  getAirParcelCountry(){
    // this.countryList = [
    //   "Singapore","Syria","Indonesia","Somalia"
    // ]

    this.countryService.getAirParcelCountry().subscribe(data=>{
      this.countryList = data
    });
  }

  getSeaParcelCountry(){
    // this.countryList = [
    //   "UAE","South Africa","Kenya"
    // ]
    this.countryService.getSeaParcelCountry().subscribe(data=>{
      this.countryList = data
    });
  }

  getServiceList(){
    this.serviceList = [
      {id: 0, type: "Warehousing Chrges"},
      {id: 1, type: "Express Charges"},
      {id: 2, type: "Withdrawal From The Post"},
      {id: 3, type: "Packets Handling Charges"},
      {id: 4, type: "Parcle Handling Charges"},
      {id: 5, type: "Inquiry Fee (For Registered Articles,Parcel and EMS)"},
      {id: 6, type: "Registration Fee (LMP - Art 29.8)"},
      {id: 7, type: "Advice of Delivery for Registered article"},
      {id: 8, type: "Minimum Surchange on Underpaid Articles"},
      {id: 9, type: "International Reply Coupons (Selling Price)"},
      {id: 10, type: "International Reply Coupons (Encashment in stamps)"},
      {id: 11, type: "Insurance Fees (up to 4000.00 )"},
      {id: 12, type: "Fumigation Fees"},
      {id: 13, type: "Late fees for posting (Per item)"}
    ]

  }

  getSubServiceList(){
    this.subServiceList = [
      {id: 0, type: "Letter (for every Rs 400.00 or Part thereof"},
      {id: 1, type: "Parcel (foe every Rs 645.00 or part thereof"}
    ]
  }

  getRate(m: number, i: number, w: number, c: string){
    if(m == null || m == undefined){
      m = 0;
    }
    if(i == null || i == undefined){
      i = 0;
    }
    if(w == null || w == undefined){
      w = 0;
    }
    if(c == null || c == undefined){
      c = "country";
    }

    // this.rate.shippingMethod = m;
    // this.rate.item = i;
    // this.rate.weight = w;
    // this.rate.country = c;

    // console.log(this.rate);
    this.rateService.getGetRate(m,i,w,c).subscribe(data=>{
      this.quotation = data
    })
    
  }

  getServiceRate(m: number, i: number, temType: number, itemSub: number){
    // console.log("service Cost");
    if(m == null || m == undefined){
      m = 0;
    }
    if(i == null || i == undefined){
      i = 0;
    }
    if( temType== null || temType == undefined){
      temType = 0;
    }
    if(itemSub == null || itemSub == undefined){
      itemSub = 0;
    }
    // this.quotation = 85.26;
    this.rateService.getGetRateForService(m,i,temType,itemSub).subscribe(data=>{
      this.quotation = data
    })
  }

}
