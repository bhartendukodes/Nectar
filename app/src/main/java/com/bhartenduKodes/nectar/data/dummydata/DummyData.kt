package com.bhartenduKodes.nectar.data.dummydata

import com.bhartenduKodes.nectar.R
import com.bhartenduKodes.nectar.data.model.Product
import com.bhartenduKodes.nectar.data.model.ProductCategory
import com.bhartenduKodes.nectar.data.model.SettingData

object DummyData {


//   private val apple=   Product(id = 1, img=  R.drawable.img_apple,name="Apple",
//            quantity="1kg, Price",amount = 23.99,  description = "")
//
//  private val banana=  Product(id = 2, img=  R.drawable.img_banana,name="Bananas",
//            quantity="7pcs, Price",amount = 4.99,description = "")
//
//
//
//    val exclusiveOffers = listOf(apple,banana,apple,banana,apple)

    val exclusiveOffer = listOf(
        Product(
            1,
            "Apple",
            "7pcs, Price",
            23.99,
            R.drawable.img_apple,
            0,
            "Mango is a tropical fruit known for its juicy, sweet, and flavorful flesh. It belongs to the drupe family and comes in various varieties, with a smooth, colorful skin and a large seed in the center.Mango is a tropical fruit known for its juicy, sweet, and flavorful flesh. It belongs to the drupe family and comes in various varieties, with a smooth, colorful skin and a large seed in the center.",
            false
        ),
        Product(
            2,
            "Banana ",
            "1kg, Price",
            4.99,
            R.drawable.img_banana,
            0,
            "Banana is a popular tropical fruit, characterized by its yellow curved appearance and sweet taste. It is a rich source of essential nutrients like potassium, fiber, and vitamins, making it a healthy and convenient snack enjoyed worldwide.",
            false
        ),
        Product(
            3,
            "Orange",
            "7pcs, Price",
            6.99,
            R.drawable.ic_orange,
            0,
            "Orange is a citrus fruit known for its vibrant color and sweet, tangy flavor. Rich in vitamin C and antioxidants, it promotes a healthy immune system and overall well-being. It is widely consumed fresh, juiced, or used in various culinary and beverage preparations.            \"Orange is a citrus fruit known for its vibrant color and sweet, tangy flavor. Rich in vitamin C and antioxidants, it promotes a healthy immune system and overall well-being. It is widely consumed fresh, juiced, or used in various culinary and beverage preparations.",
            false
        ),
        Product(
            4,
            "Mango",
            "2kg, Price",
            8.99,
            R.drawable.ic_mango,
            0,

            "Mango is a tropical fruit known for its sweet and juicy flesh. It belongs to the genus Mangifera and is rich in vitamins A and C. With a delightful flavor, mangoes are used in various culinary delights and enjoyed fresh as a refreshing treat.",
            false
        ),
        Product(
            5,
            "Strawberry",
            "7pcs, Price",
            3.99,
            R.drawable.ic_strawberry,
            0,

            "Strawberry is a sweet and juicy red fruit, known for its vibrant color and delightful taste. It is rich in vitamin C, antioxidants, and fiber, promoting overall health. Often enjoyed fresh or in various dishes, strawberries are a popular and refreshing summer treat.",
            false
        ),
        Product(
            6,
            "Banana ",
            "3kg, Price",
            3.99,
            R.drawable.img_banana,
            0,

            "Banana is a popular tropical fruit, known for its curved shape and sweet, creamy flavor. Rich in essential nutrients like potassium, fiber, and vitamins, bananas provide numerous health benefits. They are versatile, portable, and commonly enjoyed as a snack or in various culinary creations.",
            false
        ),
    )
    val bestSelling = listOf(
        Product(
            7,
            "Pepper Red",
            "17pcs, Price",
            3.99,
            R.drawable.img_red_pepper,
            0,

            "Red pepper, also known as bell pepper or capsicum, is a vibrant and nutritious vegetable. Its crisp, sweet flavor and rich red hue make it a favorite in salads, stir-fries, and as a colorful addition to various dishes. Packed with vitamins and antioxidants, red peppers are a healthy choice for any meal.",
            false
        ),
        Product(
            8,
            "Ginger",
            "440gm, Price",
            4.9,
            R.drawable.img_ginger,
            0,

            "Red ginger (Alpinia purpurata) is a striking tropical plant known for its vibrant red bracts that resemble flowers. Native to Southeast Asia, it adds a splash of color to gardens and landscapes. Besides its ornamental appeal, red ginger has traditional medicinal uses and is often used in decorative floral arrangements.",
            false
        ),
        Product(
            9,
            "Red Pepper",
            "1kg, Price",
            0.99,
            R.drawable.img_red_pepper,
            0,

            "Red pepper, also known as bell pepper or capsicum, is a vibrant and nutritious vegetable. Its crisp, sweet flavor and rich red hue make it a favorite in salads, stir-fries, and as a colorful addition to various dishes. Packed with vitamins and antioxidants, red peppers are a healthy choice for any meal.",
            false
        ),
        Product(
            10,
            "Pepper Red",
            "2kg, Price",
            5.99,
            R.drawable.img_ginger,
            0,

            "Red ginger (Alpinia purpurata) is a striking tropical plant known for its vibrant red bracts that resemble flowers. Native to Southeast Asia, it adds a splash of color to gardens and landscapes. Besides its ornamental appeal, red ginger has traditional medicinal uses and is often used in decorative floral arrangements.",
            false
        ),
        Product(
            11,
            "Ginger",
            "23gm, Price",
            3.99,
            R.drawable.img_red_pepper,
            0,

            "Red pepper, also known as bell pepper or capsicum, is a vibrant and nutritious vegetable. Its crisp, sweet flavor and rich red hue make it a favorite in salads, stir-fries, and as a colorful addition to various dishes. Packed with vitamins and antioxidants, red peppers are a healthy choice for any meal.",
            false
        ),
        Product(
            12,
            "Red Pepper ",
            "32kg, Price",
            3.99,
            R.drawable.img_ginger,
            0,

            "Red ginger (Alpinia purpurata) is a striking tropical plant known for its vibrant red bracts that resemble flowers. Native to Southeast Asia, it adds a splash of color to gardens and landscapes. Besides its ornamental appeal, red ginger has traditional medicinal uses and is often used in decorative floral arrangements.",
            false
        ),
    )
    val beverage = listOf(
        Product(
            13,
            "Diet Coke",
            "355ml, price",
            1.99,
            R.drawable.bev_pepsi,
            0,

            "Diet Coke is a popular sugar-free soft drink produced by The Coca-Cola Company. It offers the same refreshing taste as regular Coke but without the calories. It contains artificial sweeteners like aspartame and acesulfame potassium. Diet Coke has become a favored beverage among those seeking a low-calorie alternative to regular soda.",
            false
        ), Product(
            14,
            "Sprite Can",
            "325ml, price",
            1.30,
            R.drawable.bev_sprite,
            0,

            "Sprite is a popular carbonated soft drink known for its refreshing lemon-lime flavor. It's widely recognized for its clear, bubbly appearance and crisp taste, making it a popular choice for quenching thirst. Sprite is caffeine-free and enjoyed by people of all ages, offering a delightful and effervescent beverage experience.",
            false
        ), Product(
            15,
            "Apple $ graphe juice",
            "2l, price",
            1.9,
            R.drawable.bev_apple,
            0,

            "Apple is a popular fruit known for its sweet and crisp flavor. It comes in various varieties, colors, and sizes, providing a rich source of vitamins and dietary fiber. Beyond its nutritional value, apples are widely used in culinary creations like pies, juices, and sauces, making them a versatile and beloved fruit worldwide.",
            false
        ), Product(
            16,
            "orange juice",
            "55ml, price",
            10.00,
            R.drawable.bev_mango,
            0,

            "Mango, the king of fruits, is a luscious tropical delight loved worldwide. With its vibrant colors, juicy flesh, and sweet aroma, it tantalizes taste buds. Rich in vitamins, minerals, and antioxidants, mangoes offer not only a delightful taste but also numerous health benefits. A true summer indulgence!",
            false
        ), Product(
            17,
            "coca cola",
            "3l, price",
            0.75,
            R.drawable.bev_cola,
            0,

            "Cola, a beloved carbonated beverage, is an iconic symbol of refreshment worldwide. Its distinctive flavor, typically infused with caramel, citrus oils, and spices, creates a delightful taste experience. Originally introduced as a medicinal tonic, cola has evolved into a quintessential drink that brings people together and sparks nostalgia with every fizzy sip.",
            false
        ), Product(
            18,
            "pepsi can",
            "5ml, price",
            1.00,
            R.drawable.bev_pepsi,
            0,

            "Pepsi, a renowned beverage brand, is globally recognized for its refreshing and fizzy cola drink. First introduced in 1898, Pepsi has since become an iconic symbol of taste and enjoyment. Its unique blend of flavors and extensive product line has made it a popular choice for millions of consumers worldwide.",
            false
        )
    )
    val meatAndFish = listOf(
        Product(
            19,
            "Chicken",
            "1kg, price",
            2.4,
            R.drawable.ic_chicken,
            0,

            "Chicken is a popular poultry meat loved worldwide for its tender texture and versatile taste. Rich in protein and essential nutrients, it is a staple in countless cuisines, from fried and grilled to soups and curries. Its wide availability and deliciousness make it a beloved choice for many delicious dishes.",
            false
        ), Product(
            20,
            "Boil Chicken",
            "1.25kg, price",
            1.30,
            R.drawable.ic_boiler_chicken,
            0,

            "Boiler chicken refers to chickens raised intensively for meat production. These birds are typically bred to grow quickly and reach market size in a short period. However, this process often involves crowded conditions and may raise concerns about animal welfare and the use of antibiotics.",
            false
        ), Product(
            21,
            "Cooked Chicken",
            "2 kg , price",
            1.9,
            R.drawable.ic_cooked_eat,
            0,

            "Cooked chicken is a delectable and versatile protein enjoyed worldwide. Tender and flavorful, it's prepared through various methods like roasting, grilling, or frying. Its succulent texture and savory taste make it a culinary delight, perfect for sandwiches, salads, or as a main course alongside a variety of mouthwatering dishes.",
            false
        ), Product(
            22,
            "Beef",
            "5kg, price",
            10.00,
            R.drawable.ic_beef_bone,
            0,

            "Cooked beef is a delectable and versatile protein cherished worldwide. Its tender texture and rich flavor make it a culinary delight. Whether grilled, roasted, or stewed, cooked beef offers a satisfying experience that tantalizes taste buds and remains a staple in countless dishes, pleasing meat lovers of all ages.",
            false
        ), Product(
            23,
            "Fish",
            "3kg, price",
            0.75,
            R.drawable.ic_fish,
            0,

            "Cooked fish is a delectable culinary delight enjoyed worldwide. With its tender, flaky texture and rich flavors, it satisfies the palate of seafood enthusiasts. Whether grilled, baked, or fried, this succulent dish offers a healthy source of protein and essential nutrients, making it a popular choice for seafood lovers.",
            false
        ), Product(
            24,
            "Leg Chicken",
            "5kg, price",
            1.00,
            R.drawable.ic_leg_chicken,
            0,

            "Leg chicken, also known as drumstick, is a popular and succulent part of a chicken. It is prized for its tender meat and rich flavor. Whether grilled, fried, or baked, leg chicken remains a favorite among poultry enthusiasts, making it a delicious and versatile choice for various culinary delights.",
            false
        )
    )
    val fruitsAndVegitables = listOf(
        Product(
            25,
            "Mango",
            "1kg, price",
            1.99,
            R.drawable.ic_mango,
            0,

            "Mango, a luscious tropical fruit, delights taste buds with its sweet, juicy flavor and vibrant color. Originating from South Asia, it has become a global favorite. Packed with vitamins, minerals, and antioxidants, this succulent fruit offers a refreshing and nutritious treat, perfect for indulging in the summer sun.\n",
            false
        ), Product(
            26,
            "Kiwi",
            "1.25kg, price",
            1.31,
            R.drawable.ic_kiwi,
            0,

            "The kiwi, a flightless bird native to New Zealand, is known for its unique appearance and behavior. With its small, round body, long beak, and distinctive plumage, the kiwi is an iconic symbol of New Zealand's natural heritage. Sadly, these charming birds face challenges due to habitat loss and introduced predators.\n" + "\n" + "\n" + "\n" + "\n",
            false
        ), Product(
            27,
            "Pomegranate",
            "2 kg , price",
            2.9,
            R.drawable.ic_pomegranat,
            0,

            "The pomegranate is a vibrant and ancient fruit known for its juicy, ruby-red arils and sweet-tart flavor. Packed with antioxidants, vitamins, and minerals, it offers numerous health benefits. Its unique appearance and rich history make it a symbol of fertility, prosperity, and abundance in various cultures worldwide.",
            false
        ), Product(
            28,
            "Watermelon",
            "5kg, price",
            10.09,
            R.drawable.ic_watermelon,
            0,

            "\"Icy watermelon slices offer a refreshing delight on hot summer days. This juicy, vibrant fruit is packed with hydration, vitamins, and antioxidants. With its sweet and juicy flesh, biting into an ice-cold watermelon is like tasting summer itself.\"\n" + "\n" + "\n" + "\n" + "\n",
            false
        ), Product(
            29,
            "Dates",
            "3kg, price",
            13.75,
            R.drawable.ic_dates,
            0,

            "Dates are essential markers of time, enabling us to organize and remember events. They appear on calendars, signify birthdays, anniversaries, and historical milestones. Whether romantic or professional, dates hold significance in our lives, anchoring us to the past, present, and future. Their power lies in commemorating moments that shape our existence.",
            false
        ), Product(
            30,
            "Strawberry",
            "5kg, price",
            10.00,
            R.drawable.ic_strawberry,
            0,

            "Strawberry, a luscious red fruit, delights taste buds with its sweet and tangy flavor. Bursting with Vitamin C and antioxidants, this juicy gem promotes good health. A versatile delight, it stars in desserts, smoothies, and salads, adding a vibrant touch to any dish. A timeless favorite, strawberries remain nature's delectable gift.",
            false
        ), Product(
            31,
            "Lemon",
            "5kg, price",
            1.00,
            R.drawable.ic_lemon,
            0,

            "Lemon, a vibrant citrus fruit, boasts a tangy and refreshing flavor. Its zesty juice enhances countless culinary delights, from savory dishes to sweet treats. Beyond its culinary prowess, lemon is rich in vitamin C and antioxidants, promoting overall health. A small fruit with a big impact on both taste and well-being.",
            false
        ), Product(
            32,
            "BlackBerry",
            "5kg, price",
            22.00,
            R.drawable.ic_blackberry,
            0,

            "Blackberry is a fruit-bearing shrub belonging to the Rubus genus. Known for its dark purple to black, juicy berries, it is rich in antioxidants, vitamins, and minerals. Blackberries are popular in culinary delights, from pies and jams to smoothies. They also offer health benefits, contributing to improved immunity and heart health.",
            false
        ), Product(
            33,
            "Guava",
            "5kg, price",
            17.00,
            R.drawable.ic_guava,
            0,

            "Guava is a tropical fruit known for its distinctive fragrance and sweet, tangy taste. Packed with essential vitamins, minerals, and dietary fiber, guava offers numerous health benefits. Its green or pink flesh, filled with tiny seeds, is often enjoyed fresh, juiced, or used in jams and desserts worldwide.",
            false
        ), Product(
            34,
            "Banana",
            "50 piece, price",
            12.00,
            R.drawable.img_banana,
            0,

            "Banana, a popular tropical fruit, boasts a creamy texture and sweet flavor. Rich in potassium, vitamins B6 and C, and dietary fiber, bananas offer numerous health benefits, supporting heart health and aiding digestion. Versatile and convenient, they make a delightful addition to smoothies, desserts, and as a quick on-the-go snack.",
            false
        )
    )


    val findProducts = listOf(
        ProductCategory(
            1,
            "Fresh Fruits & Vegetable",
            R.drawable.ic_fresh_fruit_vegetable,
            R.color.rice_bg,
            Actions.FRESH_FRUITS_VEGETABLES
        ),
        ProductCategory(
            1,
            "cooking Oil & Ghee",
            R.drawable.cookingoilandghee,
            R.color.oil,
            Actions.COOKING_OIL_AND_GHEE
        ),
        ProductCategory(
            1, "Meat & Fish", R.drawable.meatandfish, R.color.meat, Actions.MEAT_AND_FISH
        ),
        ProductCategory(
            1,
            "Bakery & Snacks",
            R.drawable.bakeryandsnacks,
            R.color.bakery,
            Actions.BAKERY_AND_SNACKS
        ),
        ProductCategory(
            1, "Dairy & Eggs", R.drawable.dairyandegg, R.color.eggs, Actions.DAIRY_AND_EGGS
        ),
        ProductCategory(1, "Beverages", R.drawable.beverage, R.color.beverage, Actions.BEVERAGE),
        ProductCategory(
            1, "Other Stuffs", R.drawable.meatandfish, R.color.rice_bg, Actions.MEAT_AND_FISH
        ),
        ProductCategory(
            1,
            "Cold Drink & Soft Drink",
            R.drawable.dairyandegg,
            R.color.oil,
            Actions.DAIRY_AND_EGGS
        )
    )

    val settingList = listOf(
        SettingData(1, R.drawable.orders_icon, "Orders"),
        SettingData(2, R.drawable.my_details_icon, "My Details"),
        SettingData(3, R.drawable.delicery_address, "Delivery Address"),
        SettingData(4, R.drawable.ic_payment_icon, "Payment Methods"),
        SettingData(5, R.drawable.promo_cord_icon, "Promo Code"),
        SettingData(6, R.drawable.bell_icon, "Notification"),
        SettingData(7, R.drawable.help_icon, "Help"),
        SettingData(8, R.drawable.about_icon, "About")
    )

    val groceries = listOf(
        ProductCategory(1, "Rices", R.drawable.img_pulses, R.color.rice_bg, Actions.MEAT_AND_FISH),
        ProductCategory(
            1, "Pulses", R.drawable.img_rice, R.color.pulses_bg, Actions.DAIRY_AND_EGGS
        ),
        ProductCategory(
            1, "Rices", R.drawable.img_pulses, R.color.rice_bg, Actions.COOKING_OIL_AND_GHEE
        ),
        ProductCategory(1, "Pulses", R.drawable.img_rice, R.color.pulses_bg, Actions.BEVERAGE),
        ProductCategory(1, "Rices", R.drawable.img_pulses, R.color.rice_bg, Actions.BEVERAGE)
    )
}
