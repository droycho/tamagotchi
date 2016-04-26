public class Tamagotchi {
  private String mPetName;
  private int mFoodLevel = 10;

  public Tamagotchi(String petName) {
    mPetName = petName;
  }

  public String getPetName() {
    return mPetName;
  }

  public Integer getFoodLevel() {
    return mFoodLevel;
  }

  public Boolean isAlive() {
    if(mFoodLevel > 0) {
      return true;
    } else {
      return false;
    }
  }

}
