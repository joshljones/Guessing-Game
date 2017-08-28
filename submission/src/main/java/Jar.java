  import java.util.Random;

public class Jar {
  private String itemsInJar;
  private int itemCapacity;
  private int itemCount;
  
  public Jar(String itemsInJar, int itemCapacity){
    this.itemsInJar = itemsInJar;
    this.itemCapacity = itemCapacity;
  }
  
  public void setItemsInJar(String itemsInJar) {
    this.itemsInJar = itemsInJar;
  }
  
  public void setItemCapacity(int itemCapacity){
    if(itemCapacity == 0){
      throw new IllegalArgumentException("The item capacity must be greater than zero!");
    }
    this.itemCapacity = itemCapacity;
  }
  
  public String getItemsInJar(){
    return this.itemsInJar;
  }
  
  public int getItemCapacity(){
    return this.itemCapacity;
  }
  
  public void fillJar() {
    Random random = new Random();
    itemCount = random.nextInt(itemCapacity);
  }
  
  public int getItemCount() {
    return this.itemCount;
  }
    
}