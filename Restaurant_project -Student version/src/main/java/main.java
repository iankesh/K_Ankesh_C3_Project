//****************************************************
// THIS IS FOR TESTING PURPOSE, NOT THE PART OF CODE
//****************************************************

import java.time.LocalTime;

class Main {
    public static void main(String[] args) throws itemNotFoundException, restaurantNotFoundException {
//        Restaurant
        Restaurant restaurant1 = new Restaurant("Restaurant A", "Bengaluru", LocalTime.of(9, 0),LocalTime.of(23, 30));
        restaurant1.addToMenu("Paneer Tikka", 200);
        restaurant1.addToMenu("Chicken 65", 250);
        restaurant1.displayDetails();
        System.out.println("Is Open: " + restaurant1.isRestaurantOpen());
        System.out.println("Total Cost: " + restaurant1.getTotalCost());


//        Restaurant Service
        RestaurantService restaurantService = new RestaurantService();
        restaurantService.addRestaurant("Restaurant A", "Bengaluru", LocalTime.of(9, 0),LocalTime.of(18, 30));
        restaurantService.addRestaurant("Restaurant B", "Mumbai", LocalTime.of(11, 0),LocalTime.of(20, 30));
        System.out.println("Found Restaurant: " + restaurantService.findRestaurantByName("Restaurant A").getName());
        try {
            restaurantService.removeRestaurant("Restaurant A");
        }
        catch (restaurantNotFoundException r) {
            r.printStackTrace();
        }

        System.out.println("Restaurant List: ");
        for (Restaurant element: restaurantService.getRestaurants()) {
            System.out.println(element.getName());
        }
    }
}