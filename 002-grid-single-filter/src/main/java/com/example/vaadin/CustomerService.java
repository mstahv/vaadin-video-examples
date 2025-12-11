package com.example.vaadin;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Service class to manage customers.
 */
@Service
public class CustomerService {

  private static final List<Customer> CUSTOMERS = List.of(
      new Customer(1L, "John Smith", "john.smith@alpha.com"),
      new Customer(2L, "Jane Doe", "jane.doe@bluefox.io"),
      new Customer(3L, "Bob Johnson", "bob.johnson@contoso.org"),
      new Customer(4L, "Alice Williams", "alice.williams@sunset.co"),
      new Customer(5L, "Charlie Brown", "charlie.brown@northwind.net"),
      new Customer(6L, "Diana Davis", "diana.davis@aurora.dev"),
      new Customer(7L, "Edward Miller", "edward.miller@evergreen.io"),
      new Customer(8L, "Fiona Wilson", "fiona.wilson@lumenlabs.com"),
      new Customer(9L, "George Moore", "george.moore@acmemail.com"),
      new Customer(10L, "Hannah Taylor", "hannah.taylor@riverside.org"),
      new Customer(11L, "Ian Anderson", "ian.anderson@clearwater.com"),
      new Customer(12L, "Julia Thomas", "julia.thomas@peakview.net"),
      new Customer(13L, "Kevin Jackson", "kevin.jackson@heritage.co"),
      new Customer(14L, "Laura White", "laura.white@modernmail.io"),
      new Customer(15L, "Michael Harris", "michael.harris@skyline.ai"),
      new Customer(16L, "Nancy Martin", "nancy.martin@horizonmail.com"),
      new Customer(17L, "Oliver Thompson", "oliver.thompson@venture.io"),
      new Customer(18L, "Patricia Garcia", "patricia.garcia@opalstone.org"),
      new Customer(19L, "Quinn Martinez", "quinn.martinez@silverline.dev"),
      new Customer(20L, "Rachel Robinson", "rachel.robinson@trailhead.co"),
      new Customer(21L, "Samuel Smith", "samuel.smith@alpha.com"),
      new Customer(22L, "Emily Brown", "emily.brown@northwind.net"),
      new Customer(23L, "Victor Davis", "victor.davis@aurora.dev"),
      new Customer(24L, "Linda Garcia", "linda.garcia@opalstone.org"),
      new Customer(25L, "Pedro Martinez", "pedro.martinez@silverline.dev"),
      new Customer(26L, "Sophia Johnson", "sophia.johnson@contoso.org"),
      new Customer(27L, "Ethan Wilson", "ethan.wilson@lumenlabs.com"),
      new Customer(28L, "Grace Taylor", "grace.taylor@riverside.org"),
      new Customer(29L, "Marco Thompson", "marco.thompson@venture.io"),
      new Customer(30L, "Chloe White", "chloe.white@modernmail.io"),
      new Customer(31L, "Trevor Harris", "trevor.harris@skyline.ai"),
      new Customer(32L, "Leah Anderson", "leah.anderson@clearwater.com"),
      new Customer(33L, "Brian Moore", "brian.moore@acmemail.com"),
      new Customer(34L, "Carla Jackson", "carla.jackson@heritage.co"),
      new Customer(35L, "Omar Miller", "omar.miller@evergreen.io"),
      new Customer(36L, "Tessa Williams", "tessa.williams@sunset.co"),
      new Customer(37L, "Priya Patel", "priya.patel@brightpath.io"),
      new Customer(38L, "Lucas Nguyen", "lucas.nguyen@copperhill.com"),
      new Customer(39L, "Mia Rivera", "mia.rivera@cascade.io"),
      new Customer(40L, "Henry Brooks", "henry.brooks@skyline.ai"));

  public List<Customer> findAll() {
    return CUSTOMERS;
  }
}
