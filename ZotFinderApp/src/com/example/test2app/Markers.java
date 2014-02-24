package com.example.test2app;

import java.util.ArrayList;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Markers {
	
		//Array of corrresponding LatLng coordinates
		//used to store markers made from coordinates above
		//also allows toggling of all markers in respected arrays
		protected static ArrayList<Marker> emergencyArea = new ArrayList<Marker>();
		protected static ArrayList<Marker> bluePhone = new ArrayList<Marker>();
		protected static ArrayList<Marker> restroom = new ArrayList<Marker>();
		//---Booleans to show or hide markers---
		//eaShow=true - Show all Emergency Area Markers
		//eaShow=false - Hide all Emegency Area Markers
		protected static boolean eaShow=true;
		//bpShow=true - Show all Blue Phone Post Markers
		//bpShow=false - Hide all Blue Phone Post Markers
		protected static boolean bpShow=true;
		//rrShow=true - Show all Restroom Markers
		//rrSHow=false - Hide all Restroom Markers
		protected static boolean rrShow=true;
		
		//Assembly Area LatLng coordinates
		static final LatLng EA1 = new LatLng(33.64825818995, -117.841933738);
		static final LatLng EA2 = new LatLng(33.64665255641111, -117.8375963618889);
		static final LatLng EA3 = new LatLng(33.64370913405833, -117.8430245279167);
		static final LatLng EA4 = new LatLng(33.64593661552857, -117.8456994934286);
		static final LatLng EA5 = new LatLng(33.64808646936667, -117.8441101143333);
		static final LatLng EA6 = new LatLng(33.65019177882, -117.8457564792);
		static final LatLng EA7 = new LatLng(33.64512904813333, -117.8504131066667);
		static final LatLng EA8 = new LatLng(33.6482413791, -117.8470117606667);
		static final LatLng EA9 = new LatLng(33.66363793256667, -117.8551668926667);
		static final LatLng EA10 = new LatLng(33.64504260036, -117.8347193371);
		
		//Blue Phone Post LatLng coordinates
		static final LatLng BP1 = new LatLng(33.64461143420, -117.82632083200);
		static final LatLng BP2 = new LatLng(33.64387631680, -117.82420840800);
		static final LatLng BP3 = new LatLng(33.64471594450, -117.82438504100);
		static final LatLng BP4 = new LatLng(33.64386776910, -117.82498730800);
		static final LatLng BP5 = new LatLng(33.64487641310, -117.82582024200);
		static final LatLng BP6 = new LatLng(33.64654247360, -117.82484033300);
		static final LatLng BP7 = new LatLng(33.64610528000, -117.82537664800);
		static final LatLng BP8 = new LatLng(33.64419610860, -117.84083743400);
		static final LatLng BP9 = new LatLng(33.64905839530, -117.84510098400);
		static final LatLng BP10 = new LatLng(33.64349385050, -117.84226314000);
		static final LatLng BP11 = new LatLng(33.64370405740, -117.85171702000);
		static final LatLng BP12 = new LatLng(33.64691530530, -117.84654438400);
		static final LatLng BP13 = new LatLng(33.64173799290, -117.83315946900);
		static final LatLng BP14 = new LatLng(33.64445896520, -117.83897252100);
		static final LatLng BP15 = new LatLng(33.64371022740, -117.84410233300);
		static final LatLng BP16 = new LatLng(33.64608829910, -117.84557471400);
		static final LatLng BP17 = new LatLng(33.64753969390, -117.84092686500);
		static final LatLng BP18 = new LatLng(33.64643458750, -117.83975616200);
		static final LatLng BP19 = new LatLng(33.64518889740, -117.83971749700);
		static final LatLng BP20 = new LatLng(33.65199303710, -117.84644255600);
		static final LatLng BP21 = new LatLng(33.64572101130, -117.82855306700);
		static final LatLng BP22 = new LatLng(33.64463264270, -117.82798388100);
		static final LatLng BP23 = new LatLng(33.65046641380, -117.84527242000);
		static final LatLng BP24 = new LatLng(33.65023193930, -117.84332279300);
		static final LatLng BP25 = new LatLng(33.65189605460, -117.84466356600);
		static final LatLng BP26 = new LatLng(33.65251837850, -117.84440887800);
		static final LatLng BP27 = new LatLng(33.65317162390, -117.84552698200);
		static final LatLng BP28 = new LatLng(33.64342641680, -117.82685256400);
		static final LatLng BP29 = new LatLng(33.64213595920, -117.82598218000);
		static final LatLng BP30 = new LatLng(33.64757116590, -117.83373485800);
		static final LatLng BP31 = new LatLng(33.64786948010, -117.83215323800);
		static final LatLng BP32 = new LatLng(33.64810707950, -117.83180632500);
		static final LatLng BP33 = new LatLng(33.65387675630, -117.84407568800);
		static final LatLng BP34 = new LatLng(33.65254517180, -117.84304088400);
		static final LatLng BP35 = new LatLng(33.65071925160, -117.84275715100);
		static final LatLng BP36 = new LatLng(33.64797621290, -117.84563628400);
		static final LatLng BP37 = new LatLng(33.64041197960, -117.83103663500);
		static final LatLng BP38 = new LatLng(33.64217279400, -117.83199597800);
		static final LatLng BP39 = new LatLng(33.64160149960, -117.83027842100);
		static final LatLng BP40 = new LatLng(33.64138044590, -117.83109287600);
		static final LatLng BP41 = new LatLng(33.63728900290, -117.83529814900);
		static final LatLng BP42 = new LatLng(33.64350235410, -117.84841375000);
		static final LatLng BP43 = new LatLng(33.64456498940, -117.84669565700);
		static final LatLng BP44 = new LatLng(33.64762491400, -117.84473377300);
		static final LatLng BP45 = new LatLng(33.64214403140, -117.84441999900);
		static final LatLng BP46 = new LatLng(33.64210242310, -117.84437173100);
		static final LatLng BP47 = new LatLng(33.64621960920, -117.85053935700);
		static final LatLng BP48 = new LatLng(33.63825311740, -117.82542816900);
		static final LatLng BP49 = new LatLng(33.63955926060, -117.82572507600);
		static final LatLng BP50 = new LatLng(33.63918198360, -117.82519359000);
		static final LatLng BP51 = new LatLng(33.63906382560, -117.82431962300);
		static final LatLng BP52 = new LatLng(33.63953646010, -117.82454318000);
		static final LatLng BP53 = new LatLng(33.64025196950, -117.82422555800);
		static final LatLng BP54 = new LatLng(33.64064025400, -117.82420838300);
		static final LatLng BP55 = new LatLng(33.64132088780, -117.82297729900);
		static final LatLng BP56 = new LatLng(33.64008092110, -117.82363943200);
		static final LatLng BP57 = new LatLng(33.64198969320, -117.82377184000);
		static final LatLng BP58 = new LatLng(33.64206488590, -117.82307758500);
		static final LatLng BP59 = new LatLng(33.64302874370, -117.82393644100);
		static final LatLng BP60 = new LatLng(33.64381670200, -117.82256064600);
		static final LatLng BP61 = new LatLng(33.64380016780, -117.82320926200);
		static final LatLng BP62 = new LatLng(33.64453821140, -117.82341626800);
		static final LatLng BP63 = new LatLng(33.64509176670, -117.82284813900);
		static final LatLng BP64 = new LatLng(33.64555406840, -117.82365810700);
		static final LatLng BP65 = new LatLng(33.64639381910, -117.82316410800);
		static final LatLng BP66 = new LatLng(33.64652422160, -117.82403483600);
		static final LatLng BP67 = new LatLng(33.64749927250, -117.82378908400);
		static final LatLng BP68 = new LatLng(33.64787485910, -117.82423381900);
		static final LatLng BP69 = new LatLng(33.64934242880, -117.82495693900);
		static final LatLng BP70 = new LatLng(33.64913722520, -117.82574467300);
		static final LatLng BP71 = new LatLng(33.64868537000, -117.82472104700);
		static final LatLng BP72 = new LatLng(33.64817118110, -117.82541632300);
		static final LatLng BP73 = new LatLng(33.64768576520, -117.82519676500);
		static final LatLng BP74 = new LatLng(33.64745234600, -117.82464062100);
		static final LatLng BP75 = new LatLng(33.64493636580, -117.82464961200);
		static final LatLng BP76 = new LatLng(33.64549877190, -117.82515729300);
		static final LatLng BP77 = new LatLng(33.64540972910, -117.82574707500);
		static final LatLng BP78 = new LatLng(33.64524575400, -117.82452524800);
		static final LatLng BP79 = new LatLng(33.64590694600, -117.82633004900);
		static final LatLng BP80 = new LatLng(33.64626301520, -117.82620786600);
		static final LatLng BP81 = new LatLng(33.64724097200, -117.82553436600);
		static final LatLng BP82 = new LatLng(33.64569414600, -117.82467813600);
		static final LatLng BP83 = new LatLng(33.64467724390, -117.82802472300);
		static final LatLng BP84 = new LatLng(33.64472574750, -117.82806443800);
		static final LatLng BP85 = new LatLng(33.64477514070, -117.82810525700);
		static final LatLng BP86 = new LatLng(33.64482146310, -117.82814874500);
		static final LatLng BP87 = new LatLng(33.64486755650, -117.82818417400);
		static final LatLng BP88 = new LatLng(33.64491453680, -117.82821999100);
		static final LatLng BP89 = new LatLng(33.64782638500, -117.83288019000);
		static final LatLng BP90 = new LatLng(33.63945622420, -117.85039789900);
		static final LatLng BP91 = new LatLng(33.64312710330, -117.84672659200);
		static final LatLng BP92 = new LatLng(33.65045524010, -117.84630872400);
		static final LatLng BP93 = new LatLng(33.65050738490, -117.84634721100);
		static final LatLng BP94 = new LatLng(33.65055331880, -117.84638724300);
		static final LatLng BP95 = new LatLng(33.65060145750, -117.84643014300);
		static final LatLng BP96 = new LatLng(33.65064555970, -117.84647392400);
		static final LatLng BP97 = new LatLng(33.64792994650, -117.84735102800);
		static final LatLng BP98 = new LatLng(33.66500586130, -117.85404937400);
		static final LatLng BP99 = new LatLng(33.64259210590, -117.85165248800);
		static final LatLng BP100 = new LatLng(33.64340528940, -117.85044689900);
		static final LatLng BP101 = new LatLng(33.64519494130, -117.83466970600);
		static final LatLng BP102 = new LatLng(33.64407252260, -117.83645722300);
		static final LatLng BP103 = new LatLng(33.64498185810, -117.83613268000);
		static final LatLng BP104 = new LatLng(33.64809608360, -117.82868278800);
		static final LatLng BP105 = new LatLng(33.64768919230, -117.82620072400);
		static final LatLng BP106 = new LatLng(33.64750855700, -117.82693968200);
		static final LatLng BP107 = new LatLng(33.64724518450, -117.82857378900);
		static final LatLng BP108 = new LatLng(33.64973589330, -117.84182167500);
		static final LatLng BP109 = new LatLng(33.64976467460, -117.84177426300);
		static final LatLng BP110 = new LatLng(33.64979846710, -117.84172371700);
		static final LatLng BP111 = new LatLng(33.64983436140, -117.84167197000);
		static final LatLng BP112 = new LatLng(33.64986922900, -117.84161906700);
		static final LatLng BP113 = new LatLng(33.64751464300, -117.83812743700);
		static final LatLng BP114 = new LatLng(33.64753326290, -117.83807057000);
		static final LatLng BP115 = new LatLng(33.64755912520, -117.83801414200);
		static final LatLng BP116 = new LatLng(33.64758881920, -117.83796370100);
		static final LatLng BP117 = new LatLng(33.64762405810, -117.83791019600);
		static final LatLng BP118 = new LatLng(33.64765684390, -117.83786174600);
		static final LatLng BP119 = new LatLng(33.64768500790, -117.83780527000);
		static final LatLng BP120 = new LatLng(33.64730316520, -117.83746235300);
		static final LatLng BP121 = new LatLng(33.64734802630, -117.83748622900);
		static final LatLng BP122 = new LatLng(33.64739780030, -117.83751460200);
		static final LatLng BP123 = new LatLng(33.64744521600, -117.83754180200);
		static final LatLng BP124 = new LatLng(33.64749463030, -117.83756889500);
		static final LatLng BP125 = new LatLng(33.64754610290, -117.83759644100);
		static final LatLng BP126 = new LatLng(33.64759664030, -117.83762483600);
		static final LatLng BP127 = new LatLng(33.64718514210, -117.83666196900);
		static final LatLng BP128 = new LatLng(33.64722652180, -117.83670263500);
		static final LatLng BP129 = new LatLng(33.64726836540, -117.83674567200);
		static final LatLng BP130 = new LatLng(33.64730953400, -117.83678549500);
		static final LatLng BP131 = new LatLng(33.64735233160, -117.83682633500);
		static final LatLng BP132 = new LatLng(33.64739602340, -117.83686684800);
		static final LatLng BP133 = new LatLng(33.64743778550, -117.83690870200);
		static final LatLng BP134 = new LatLng(33.64308728510, -117.83846291200);
		static final LatLng BP135 = new LatLng(33.64311174420, -117.83839965000);
		static final LatLng BP136 = new LatLng(33.64313751980, -117.83833270300);
		static final LatLng BP137 = new LatLng(33.64316917280, -117.83827233900);
		static final LatLng BP138 = new LatLng(33.64320161680, -117.83821371600);
		static final LatLng BP139 = new LatLng(33.64323141310, -117.83815462700);
		static final LatLng BP140 = new LatLng(33.64326824920, -117.83809502200);
		static final LatLng BP141 = new LatLng(33.64327079090, -117.83716398200);
		static final LatLng BP142 = new LatLng(33.64323367720, -117.83720987400);
		static final LatLng BP143 = new LatLng(33.64320061730, -117.83725818700);
		static final LatLng BP144 = new LatLng(33.64317029380, -117.83731254900);
		static final LatLng BP145 = new LatLng(33.64314192190, -117.83736468500);
		static final LatLng BP146 = new LatLng(33.64310585450, -117.83741486000);
		static final LatLng BP147 = new LatLng(33.64307501440, -117.83746892800);
		static final LatLng BP148 = new LatLng(33.64256063390, -117.83469813900);
		static final LatLng BP149 = new LatLng(33.64581629270, -117.84810724600);
		static final LatLng BP150 = new LatLng(33.64093973230, -117.83308656100);
		static final LatLng BP151 = new LatLng(33.64555614920, -117.84448882300);
		static final LatLng BP152 = new LatLng(33.64807544110, -117.84780345800);
		static final LatLng BP153 = new LatLng(33.64231813710, -117.82890552800);
		static final LatLng BP154 = new LatLng(33.64718995450, -117.83749799100);
		static final LatLng BP155 = new LatLng(33.64838932580, -117.83088987000);
		
		//Restroom LatLng coordinates
		static final LatLng RR1 = new LatLng(33.65010225160, -117.84559094400);
		static final LatLng RR2 = new LatLng(33.65040342400, -117.84496139200);
		static final LatLng RR3 = new LatLng(33.64998896190, -117.84488620900);
		static final LatLng RR4 = new LatLng(33.64995078660, -117.84501711000);
		static final LatLng RR5 = new LatLng(33.64431413160, -117.84078154500);
		static final LatLng RR6 = new LatLng(33.64354383150, -117.84396563000);
		static final LatLng RR7 = new LatLng(33.64568623610, -117.84575639400);
		static final LatLng RR8 = new LatLng(33.64839436640, -117.84452293200);
		static final LatLng RR9 = new LatLng(33.64872460950, -117.84249951400);
		static final LatLng RR10 = new LatLng(33.64822441410, -117.84365204600);
		static final LatLng RR11 = new LatLng(33.64346134070, -117.84343369700);
		static final LatLng RR12 = new LatLng(33.64397988970, -117.84346632700);
		static final LatLng RR13 = new LatLng(33.64640262790, -117.84050172300);
		static final LatLng RR14 = new LatLng(33.64649153390, -117.83743367200);
		static final LatLng RR15 = new LatLng(33.64628115630, -117.83740776700);
		static final LatLng RR16 = new LatLng(33.64712367770, -117.83906408700);
		static final LatLng RR17 = new LatLng(33.64699239470, -117.83942377800);
		static final LatLng RR18 = new LatLng(33.64814746040, -117.84786043000);
		static final LatLng RR19 = new LatLng(33.64397676030, -117.84175444400);
		static final LatLng RR20 = new LatLng(33.64414576200, -117.84197579900);
		static final LatLng RR21 = new LatLng(33.64446559420, -117.84160199500);

	
		
		public static void addEmergencyAreaMarker(GoogleMap mMap){
			//Makes markers from corresponding LatLng coordinates
	    	 //and adds them to their respective array 
	    	 
	    	 //emergency assembly areas
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA1).title("Gateway").icon(BitmapDescriptorFactory.fromResource(R.drawable.emergency_area_icon))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA2).title("Social Sciences").icon(BitmapDescriptorFactory.fromResource(R.drawable.emergency_area_icon))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA3).title("Engineering").icon(BitmapDescriptorFactory.fromResource(R.drawable.emergency_area_icon))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA4).title("Biological Sciences").icon(BitmapDescriptorFactory.fromResource(R.drawable.emergency_area_icon))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA5).title("Humanities").icon(BitmapDescriptorFactory.fromResource(R.drawable.emergency_area_icon))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA6).title("Arts").icon(BitmapDescriptorFactory.fromResource(R.drawable.emergency_area_icon))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA7).title("Medical Sciences").icon(BitmapDescriptorFactory.fromResource(R.drawable.emergency_area_icon))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA8).title("Athletics/Central Plant").icon(BitmapDescriptorFactory.fromResource(R.drawable.emergency_area_icon))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA9).title("NorthCampus").icon(BitmapDescriptorFactory.fromResource(R.drawable.emergency_area_icon))));
	         emergencyArea.add(mMap.addMarker(new MarkerOptions().position(EA10).title("Residential").icon(BitmapDescriptorFactory.fromResource(R.drawable.emergency_area_icon))));
	         
		}
		public static void addBluePhoneMarker (GoogleMap mMap){
			 //Emergency blue phone posts
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP1).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP2).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP3).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP4).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP5).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP6).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP7).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP8).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP9).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP10).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP11).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP12).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP13).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP14).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP15).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP16).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP17).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP18).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP19).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP20).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP21).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP22).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP23).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP24).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP25).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP26).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP27).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP28).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP29).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP30).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP31).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP32).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP33).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP34).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP35).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP36).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP37).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP38).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP39).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP40).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP41).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP42).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP43).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP44).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP45).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP46).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP47).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP48).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP49).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP50).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP51).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP52).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP53).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP54).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP55).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP56).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP57).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP58).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP59).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP60).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP61).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP62).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP63).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP64).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP65).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP66).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP67).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP68).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP69).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP70).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP71).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP72).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP73).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP74).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP75).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP76).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP77).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP78).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP79).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP80).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP81).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP82).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP83).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP84).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP85).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP86).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP87).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP88).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP89).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP90).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP91).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP92).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP93).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP94).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP95).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP96).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP97).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP98).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP99).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP100).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP101).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP102).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP103).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP104).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP105).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP106).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP107).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP108).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP109).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP110).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP111).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP112).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP113).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP114).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP115).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP116).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP117).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP118).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP119).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP120).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP121).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP122).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP123).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP124).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP125).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP126).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP127).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP128).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP129).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP130).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP131).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP132).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP133).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP134).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP135).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP136).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP137).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP138).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP139).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP140).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP141).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP142).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP143).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP144).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP145).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP146).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP147).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP148).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP149).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP150).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP151).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP152).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP153).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP154).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));
	         bluePhone.add(mMap.addMarker(new MarkerOptions().position(BP155).title("Blue Light Phone").icon(BitmapDescriptorFactory.fromResource(R.drawable.blue_phone_icon))));

		}
		
		public static void addRestroomMarker(GoogleMap mMap){
			 //Restroom markers
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR1).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR2).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR3).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR4).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR5).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR6).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR7).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR8).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR9).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR10).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR11).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR12).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR13).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR14).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR15).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR16).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR17).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR18).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR19).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR20).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
	         restroom.add(mMap.addMarker(new MarkerOptions().position(RR21).title("Restroom").icon(BitmapDescriptorFactory.fromResource(R.drawable.restroom_icon))));
		}
		
		
		public static void toggleEmergencyMarker(){
			
			//if eaShow=true
			if(eaShow){
				//hide all the emergency area markers
				for(Marker m :emergencyArea){
					m.setVisible(false);
				}
				eaShow = false;
			}
			//else if eaShow=false
			else{
				//show all the emergency area markers
				for( Marker m : emergencyArea){
					m.setVisible(true);
				}
				eaShow = true;
			}
		}
		
		public static void toggleBluePhone(){
			//if bpShow=true
			if(bpShow){
				//hide all Blue Phone Post markers
				for (Marker m : bluePhone){
					m.setVisible(false);
				}
				bpShow = false;
			}
			//else if bpShow=false
			else{
				//show all Blue PHone Post Markers
				for (Marker m : bluePhone){
					m.setVisible(true);
				}
				bpShow = true;
			}
		}
		
		public static void toggleRestroom(){
			//if rrShow=true
			if(rrShow){
				//hide all Restroom markers
				for (Marker m : restroom){
					m.setVisible(false);
				}
				rrShow = false;
			}
			//else if 
			else{
				//show all Restroom markers
				for (Marker m : restroom){
					m.setVisible(true);
				}
				rrShow = true;
			}
		}
		
}
