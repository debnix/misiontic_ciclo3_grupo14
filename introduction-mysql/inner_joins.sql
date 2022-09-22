

SELECT c.country, ci.city, ad.address address_store, ad.phone phone_store, cm.first_name as firstname_customer, 
	cm.last_name lastname_customer, cm.email email_customer, st.first_name firstname_staff, st.last_name lastname_staff,
    st.email email_staff, fi.title, fi.description, l.name language, ct.name category, ac.first_name firstname_actor,
    ac.last_name lastname_actor
FROM country c 
INNER JOIN city ci ON c.country_id = ci.country_id 
INNER JOIN address ad ON ad.city_id = ci.city_id
INNER JOIN customer cm ON cm.address_id = ad.address_id
INNER JOIN rental rt ON rt.customer_id = cm.customer_id
INNER JOIN staff st ON st.staff_id = rt.staff_id
INNER JOIN inventory i ON i.inventory_id = rt.inventory_id
INNER JOIN film fi ON fi.film_id = i.film_id
INNER JOIN language l ON l.language_id = fi.language_id
INNER JOIN film_category fc ON fc.film_id = fi.film_id
INNER JOIN category ct ON ct.category_id = fc.category_id
INNER JOIN film_actor fa ON fa.film_id = fi.film_id
INNER JOIN actor ac ON ac.actor_id = fa.actor_id
WHERE c.country = "Colombia";