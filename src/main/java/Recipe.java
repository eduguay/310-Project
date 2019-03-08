import java.util.ArrayList;

public class Recipe {
// private String uri;
// private String label;
// private String image;
// private String source;
// private String url;
// private String shareAs;
// private float yield;
// ArrayList < Object > dietLabels = new ArrayList < Object > ();
// ArrayList < Object > healthLabels = new ArrayList < Object > ();
// ArrayList < Object > cautions = new ArrayList < Object > ();
// ArrayList < Object > ingredientLines = new ArrayList < Object > ();
// ArrayList < Object > ingredients = new ArrayList < Object > ();
// private float calories;
// private float totalWeight;
// private float totalTime;
// TotalNutrients TotalNutrientsObject;
// TotalDaily TotalDailyObject;
// ArrayList < Object > digest = new ArrayList < Object > ();
//
//
// // Getter Methods 
//
// public String getUri() {
//  return uri;
// }
//
// public String getLabel() {
//  return label;
// }
//
// public String getImage() {
//  return image;
// }
//
// public String getSource() {
//  return source;
// }
//
// public String getUrl() {
//  return url;
// }
//
// public String getShareAs() {
//  return shareAs;
// }
//
// public float getYield() {
//  return yield;
// }
//
// public float getCalories() {
//  return calories;
// }
//
// public float getTotalWeight() {
//  return totalWeight;
// }
//
// public float getTotalTime() {
//  return totalTime;
// }
//
// public TotalNutrients getTotalNutrients() {
//  return TotalNutrientsObject;
// }
//
// public TotalDaily getTotalDaily() {
//  return TotalDailyObject;
// }
//
// // Setter Methods 
//
// public void setUri(String uri) {
//  this.uri = uri;
// }
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setImage(String image) {
//  this.image = image;
// }
//
// public void setSource(String source) {
//  this.source = source;
// }
//
// public void setUrl(String url) {
//  this.url = url;
// }
//
// public void setShareAs(String shareAs) {
//  this.shareAs = shareAs;
// }
//
// public void setYield(float yield) {
//  this.yield = yield;
// }
//
// public void setCalories(float calories) {
//  this.calories = calories;
// }
//
// public void setTotalWeight(float totalWeight) {
//  this.totalWeight = totalWeight;
// }
//
// public void setTotalTime(float totalTime) {
//  this.totalTime = totalTime;
// }
//
// public void setTotalNutrients(TotalNutrients totalNutrientsObject) {
//  this.TotalNutrientsObject = totalNutrientsObject;
// }
//
// public void setTotalDaily(TotalDaily totalDailyObject) {
//  this.TotalDailyObject = totalDailyObject;
// }
//}
//public class TotalDaily {
// ENERC_KCAL ENERC_KCALObject;
// FAT FATObject;
// FASAT FASATObject;
// CHOCDF CHOCDFObject;
// FIBTG FIBTGObject;
// PROCNT PROCNTObject;
// CHOLE CHOLEObject;
// NA NAObject;
// CA CAObject;
// MG MGObject;
// K KObject;
// FE FEObject;
// ZN ZNObject;
// P PObject;
// VITA_RAE VITA_RAEObject;
// VITC VITCObject;
// THIA THIAObject;
// RIBF RIBFObject;
// NIA NIAObject;
// VITB6A VITB6AObject;
// FOLDFE FOLDFEObject;
// VITB12 VITB12Object;
// VITD VITDObject;
// TOCPHA TOCPHAObject;
// VITK1 VITK1Object;
//
//
// // Getter Methods 
//
// public ENERC_KCAL getENERC_KCAL() {
//  return ENERC_KCALObject;
// }
//
// public FAT getFAT() {
//  return FATObject;
// }
//
// public FASAT getFASAT() {
//  return FASATObject;
// }
//
// public CHOCDF getCHOCDF() {
//  return CHOCDFObject;
// }
//
// public FIBTG getFIBTG() {
//  return FIBTGObject;
// }
//
// public PROCNT getPROCNT() {
//  return PROCNTObject;
// }
//
// public CHOLE getCHOLE() {
//  return CHOLEObject;
// }
//
// public NA getNA() {
//  return NAObject;
// }
//
// public CA getCA() {
//  return CAObject;
// }
//
// public MG getMG() {
//  return MGObject;
// }
//
// public K getK() {
//  return KObject;
// }
//
// public FE getFE() {
//  return FEObject;
// }
//
// public ZN getZN() {
//  return ZNObject;
// }
//
// public P getP() {
//  return PObject;
// }
//
// public VITA_RAE getVITA_RAE() {
//  return VITA_RAEObject;
// }
//
// public VITC getVITC() {
//  return VITCObject;
// }
//
// public THIA getTHIA() {
//  return THIAObject;
// }
//
// public RIBF getRIBF() {
//  return RIBFObject;
// }
//
// public NIA getNIA() {
//  return NIAObject;
// }
//
// public VITB6A getVITB6A() {
//  return VITB6AObject;
// }
//
// public FOLDFE getFOLDFE() {
//  return FOLDFEObject;
// }
//
// public VITB12 getVITB12() {
//  return VITB12Object;
// }
//
// public VITD getVITD() {
//  return VITDObject;
// }
//
// public TOCPHA getTOCPHA() {
//  return TOCPHAObject;
// }
//
// public VITK1 getVITK1() {
//  return VITK1Object;
// }
//
// // Setter Methods 
//
// public void setENERC_KCAL(ENERC_KCAL ENERC_KCALObject) {
//  this.ENERC_KCALObject = ENERC_KCALObject;
// }
//
// public void setFAT(FAT FATObject) {
//  this.FATObject = FATObject;
// }
//
// public void setFASAT(FASAT FASATObject) {
//  this.FASATObject = FASATObject;
// }
//
// public void setCHOCDF(CHOCDF CHOCDFObject) {
//  this.CHOCDFObject = CHOCDFObject;
// }
//
// public void setFIBTG(FIBTG FIBTGObject) {
//  this.FIBTGObject = FIBTGObject;
// }
//
// public void setPROCNT(PROCNT PROCNTObject) {
//  this.PROCNTObject = PROCNTObject;
// }
//
// public void setCHOLE(CHOLE CHOLEObject) {
//  this.CHOLEObject = CHOLEObject;
// }
//
// public void setNA(NA NAObject) {
//  this.NAObject = NAObject;
// }
//
// public void setCA(CA CAObject) {
//  this.CAObject = CAObject;
// }
//
// public void setMG(MG MGObject) {
//  this.MGObject = MGObject;
// }
//
// public void setK(K KObject) {
//  this.KObject = KObject;
// }
//
// public void setFE(FE FEObject) {
//  this.FEObject = FEObject;
// }
//
// public void setZN(ZN ZNObject) {
//  this.ZNObject = ZNObject;
// }
//
// public void setP(P PObject) {
//  this.PObject = PObject;
// }
//
// public void setVITA_RAE(VITA_RAE VITA_RAEObject) {
//  this.VITA_RAEObject = VITA_RAEObject;
// }
//
// public void setVITC(VITC VITCObject) {
//  this.VITCObject = VITCObject;
// }
//
// public void setTHIA(THIA THIAObject) {
//  this.THIAObject = THIAObject;
// }
//
// public void setRIBF(RIBF RIBFObject) {
//  this.RIBFObject = RIBFObject;
// }
//
// public void setNIA(NIA NIAObject) {
//  this.NIAObject = NIAObject;
// }
//
// public void setVITB6A(VITB6A VITB6AObject) {
//  this.VITB6AObject = VITB6AObject;
// }
//
// public void setFOLDFE(FOLDFE FOLDFEObject) {
//  this.FOLDFEObject = FOLDFEObject;
// }
//
// public void setVITB12(VITB12 VITB12Object) {
//  this.VITB12Object = VITB12Object;
// }
//
// public void setVITD(VITD VITDObject) {
//  this.VITDObject = VITDObject;
// }
//
// public void setTOCPHA(TOCPHA TOCPHAObject) {
//  this.TOCPHAObject = TOCPHAObject;
// }
//
// public void setVITK1(VITK1 VITK1Object) {
//  this.VITK1Object = VITK1Object;
// }
//}
//public class VITK1 {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class TOCPHA {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class VITD {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class VITB12 {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FOLDFE {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class VITB6A {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class NIA {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class RIBF {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class THIA {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class VITC {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class VITA_RAE {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class P {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class ZN {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FE {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class K {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class MG {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class CA {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class NA {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class CHOLE {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class PROCNT {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FIBTG {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class CHOCDF {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FASAT {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FAT {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class ENERC_KCAL {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class TotalNutrients {
// ENERC_KCAL ENERC_KCALObject;
// FAT FATObject;
// FASAT FASATObject;
// FATRN FATRNObject;
// FAMS FAMSObject;
// FAPU FAPUObject;
// CHOCDF CHOCDFObject;
// FIBTG FIBTGObject;
// SUGAR SUGARObject;
// PROCNT PROCNTObject;
// CHOLE CHOLEObject;
// NA NAObject;
// CA CAObject;
// MG MGObject;
// K KObject;
// FE FEObject;
// ZN ZNObject;
// P PObject;
// VITA_RAE VITA_RAEObject;
// VITC VITCObject;
// THIA THIAObject;
// RIBF RIBFObject;
// NIA NIAObject;
// VITB6A VITB6AObject;
// FOLDFE FOLDFEObject;
// FOLFD FOLFDObject;
// VITB12 VITB12Object;
// VITD VITDObject;
// TOCPHA TOCPHAObject;
// VITK1 VITK1Object;
//
//
// // Getter Methods 
//
// public ENERC_KCAL getENERC_KCAL() {
//  return ENERC_KCALObject;
// }
//
// public FAT getFAT() {
//  return FATObject;
// }
//
// public FASAT getFASAT() {
//  return FASATObject;
// }
//
// public FATRN getFATRN() {
//  return FATRNObject;
// }
//
// public FAMS getFAMS() {
//  return FAMSObject;
// }
//
// public FAPU getFAPU() {
//  return FAPUObject;
// }
//
// public CHOCDF getCHOCDF() {
//  return CHOCDFObject;
// }
//
// public FIBTG getFIBTG() {
//  return FIBTGObject;
// }
//
// public SUGAR getSUGAR() {
//  return SUGARObject;
// }
//
// public PROCNT getPROCNT() {
//  return PROCNTObject;
// }
//
// public CHOLE getCHOLE() {
//  return CHOLEObject;
// }
//
// public NA getNA() {
//  return NAObject;
// }
//
// public CA getCA() {
//  return CAObject;
// }
//
// public MG getMG() {
//  return MGObject;
// }
//
// public K getK() {
//  return KObject;
// }
//
// public FE getFE() {
//  return FEObject;
// }
//
// public ZN getZN() {
//  return ZNObject;
// }
//
// public P getP() {
//  return PObject;
// }
//
// public VITA_RAE getVITA_RAE() {
//  return VITA_RAEObject;
// }
//
// public VITC getVITC() {
//  return VITCObject;
// }
//
// public THIA getTHIA() {
//  return THIAObject;
// }
//
// public RIBF getRIBF() {
//  return RIBFObject;
// }
//
// public NIA getNIA() {
//  return NIAObject;
// }
//
// public VITB6A getVITB6A() {
//  return VITB6AObject;
// }
//
// public FOLDFE getFOLDFE() {
//  return FOLDFEObject;
// }
//
// public FOLFD getFOLFD() {
//  return FOLFDObject;
// }
//
// public VITB12 getVITB12() {
//  return VITB12Object;
// }
//
// public VITD getVITD() {
//  return VITDObject;
// }
//
// public TOCPHA getTOCPHA() {
//  return TOCPHAObject;
// }
//
// public VITK1 getVITK1() {
//  return VITK1Object;
// }
//
// // Setter Methods 
//
// public void setENERC_KCAL(ENERC_KCAL ENERC_KCALObject) {
//  this.ENERC_KCALObject = ENERC_KCALObject;
// }
//
// public void setFAT(FAT FATObject) {
//  this.FATObject = FATObject;
// }
//
// public void setFASAT(FASAT FASATObject) {
//  this.FASATObject = FASATObject;
// }
//
// public void setFATRN(FATRN FATRNObject) {
//  this.FATRNObject = FATRNObject;
// }
//
// public void setFAMS(FAMS FAMSObject) {
//  this.FAMSObject = FAMSObject;
// }
//
// public void setFAPU(FAPU FAPUObject) {
//  this.FAPUObject = FAPUObject;
// }
//
// public void setCHOCDF(CHOCDF CHOCDFObject) {
//  this.CHOCDFObject = CHOCDFObject;
// }
//
// public void setFIBTG(FIBTG FIBTGObject) {
//  this.FIBTGObject = FIBTGObject;
// }
//
// public void setSUGAR(SUGAR SUGARObject) {
//  this.SUGARObject = SUGARObject;
// }
//
// public void setPROCNT(PROCNT PROCNTObject) {
//  this.PROCNTObject = PROCNTObject;
// }
//
// public void setCHOLE(CHOLE CHOLEObject) {
//  this.CHOLEObject = CHOLEObject;
// }
//
// public void setNA(NA NAObject) {
//  this.NAObject = NAObject;
// }
//
// public void setCA(CA CAObject) {
//  this.CAObject = CAObject;
// }
//
// public void setMG(MG MGObject) {
//  this.MGObject = MGObject;
// }
//
// public void setK(K KObject) {
//  this.KObject = KObject;
// }
//
// public void setFE(FE FEObject) {
//  this.FEObject = FEObject;
// }
//
// public void setZN(ZN ZNObject) {
//  this.ZNObject = ZNObject;
// }
//
// public void setP(P PObject) {
//  this.PObject = PObject;
// }
//
// public void setVITA_RAE(VITA_RAE VITA_RAEObject) {
//  this.VITA_RAEObject = VITA_RAEObject;
// }
//
// public void setVITC(VITC VITCObject) {
//  this.VITCObject = VITCObject;
// }
//
// public void setTHIA(THIA THIAObject) {
//  this.THIAObject = THIAObject;
// }
//
// public void setRIBF(RIBF RIBFObject) {
//  this.RIBFObject = RIBFObject;
// }
//
// public void setNIA(NIA NIAObject) {
//  this.NIAObject = NIAObject;
// }
//
// public void setVITB6A(VITB6A VITB6AObject) {
//  this.VITB6AObject = VITB6AObject;
// }
//
// public void setFOLDFE(FOLDFE FOLDFEObject) {
//  this.FOLDFEObject = FOLDFEObject;
// }
//
// public void setFOLFD(FOLFD FOLFDObject) {
//  this.FOLFDObject = FOLFDObject;
// }
//
// public void setVITB12(VITB12 VITB12Object) {
//  this.VITB12Object = VITB12Object;
// }
//
// public void setVITD(VITD VITDObject) {
//  this.VITDObject = VITDObject;
// }
//
// public void setTOCPHA(TOCPHA TOCPHAObject) {
//  this.TOCPHAObject = TOCPHAObject;
// }
//
// public void setVITK1(VITK1 VITK1Object) {
//  this.VITK1Object = VITK1Object;
// }
//}
//public class VITK1 {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class TOCPHA {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class VITD {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class VITB12 {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FOLFD {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FOLDFE {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class VITB6A {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class NIA {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class RIBF {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class THIA {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class VITC {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class VITA_RAE {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class P {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class ZN {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FE {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class K {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class MG {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class CA {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class NA {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class CHOLE {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class PROCNT {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class SUGAR {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FIBTG {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class CHOCDF {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FAPU {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FAMS {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FATRN {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FASAT {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class FAT {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
//}
//public class ENERC_KCAL {
// private String label;
// private float quantity;
// private String unit;
//
//
// // Getter Methods 
//
// public String getLabel() {
//  return label;
// }
//
// public float getQuantity() {
//  return quantity;
// }
//
// public String getUnit() {
//  return unit;
// }
//
// // Setter Methods 
//
// public void setLabel(String label) {
//  this.label = label;
// }
//
// public void setQuantity(float quantity) {
//  this.quantity = quantity;
// }
//
// public void setUnit(String unit) {
//  this.unit = unit;
// }
}
