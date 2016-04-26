public class Tamagotchi {
  private String mPetName;
  private Integer mFoodLevel;
  private Integer mSleepLevel;
  private Integer mActivityLevel;

  public Tamagotchi(String petName, Integer foodLevel, Integer sleepLevel, Integer activityLevel) {
    mPetName = petName;
    mFoodLevel = foodLevel;
    mSleepLevel = sleepLevel;
    mActivityLevel = activityLevel;
  }

  public String getPetName() {
    return mPetName;
  }

  public Integer getFoodLevel() {
    return mFoodLevel;
  }

  public Integer downFoodLevel(Integer food) {
    mFoodLevel = mFoodLevel - 1;
    return mFoodLevel;
  }

  public String isAlive() {
    if(mFoodLevel > 0) {
      return mPetName + " is alive.";
    } else {
      return mPetName + " is dead.";
    }
  }

  public Integer getSleepLevel() {
    return mSleepLevel;
  }

  public Integer getActivityLevel() {
    return mActivityLevel;
  }

}
