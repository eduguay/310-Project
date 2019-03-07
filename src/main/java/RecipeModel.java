import java.util.ArrayList;

public class RecipeModel {
 private String q;
 private float from;
 private float to;
 Parameter ParamsObject;
 private boolean more;
 private float count;
 ArrayList < Object > hits = new ArrayList < Object > ();


 // Getter Methods 

 public String getQ() {
  return q;
 }

 public float getFrom() {
  return from;
 }

 public float getTo() {
  return to;
 }

 public Parameter getParams() {
  return ParamsObject;
 }

 public boolean getMore() {
  return more;
 }

 public float getCount() {
  return count;
 }

 // Setter Methods 

 public void setQ(String q) {
  this.q = q;
 }

 public void setFrom(float from) {
  this.from = from;
 }

 public void setTo(float to) {
  this.to = to;
 }

 public void setParams(Parameter paramsObject) {
  this.ParamsObject = paramsObject;
 }

 public void setMore(boolean more) {
  this.more = more;
 }

 public void setCount(float count) {
  this.count = count;
 }
}
