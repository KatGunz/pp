package DTO;

import org.hibernate.validator.constraints.NotBlank;

import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name = "food")
public class Food {

    @Column(name = "foodID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private long foodID;

    @Column(name = "foodName")
    @NotBlank
    private String foodName;
    @Column(name = "calories")
    private double calories;
    @Column(name = "totalFat")
    private double totalFat;
    @Column(name = "cholesterol")
    private double cholesterol;
    @Column(name = "sodium")
    private double sodium;
    @Column(name = "totalCarbs")
    private double totalCarbs;
    @Column(name = "protein")
    private double protein;
    @Column(name = "vitaminA")
    private double vitaminA;
    @Column(name = "vitaminB")
    private double vitaminB;
    @Column(name = "vitaminC")
    private double vitaminC;
    @Column(name = "vitaminD")
    private double vitaminD;
    @Column(name = "calcium")
    private double calcium;
    @Column(name = "iron")
    private double iron;

    public long getFoodID() {
        return foodID;
    }

    public void setFoodID(long foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(double totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(double vitaminA) {
        this.vitaminA = vitaminA;
    }

    public double getVitaminB() {
        return vitaminB;
    }

    public void setVitaminB(double vitaminB) {
        this.vitaminB = vitaminB;
    }

    public double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(double vitaminC) {
        this.vitaminC = vitaminC;
    }

    public double getVitaminD() {
        return vitaminD;
    }

    public void setVitaminD(double vitaminD) {
        this.vitaminD = vitaminD;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }
}
