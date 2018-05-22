package com.project.winter.DTO;

import org.hibernate.validator.constraints.NotBlank;

import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name = "food")
public class Food {

    @Column(name = "Food_Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private long foodId;

    @Column(name = "Food_Name")
    @NotBlank
    private String foodName;
    @Column(name = "Calories")
    private double calories;
    @Column(name = "Total_Fat")
    private double totalFat;
    @Column(name = "Cholesterol")
    private double cholesterol;
    @Column(name = "Sodium")
    private double sodium;
    @Column(name = "Total_Carbs")
    private double totalCarbs;
    @Column(name = "Protein")
    private double protein;
    @Column(name = "Vitamin_A")
    private double vitaminA;
    @Column(name = "Vitamin_B")
    private double vitaminB;
    @Column(name = "Vitamin_C")
    private double vitaminC;
    @Column(name = "Vitamin_D")
    private double vitaminD;
    @Column(name = "Calcium")
    private double calcium;
    @Column(name = "Iron")
    private double iron;

    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
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
