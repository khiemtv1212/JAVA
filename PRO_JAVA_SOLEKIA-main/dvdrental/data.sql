SELECT category_id,
    name
FROM category;
select film_id,
    title,
    tmdb_poster_path
from film;
SELECT *
FROM film
ORDER BY film_id
LIMIT 10 OFFSET 10;
select *
from film;
select *
from category;
INSERT INTO film (
        title,
        description,
        release_year,
        language_id,
        rental_duration,
        rental_rate,
        length,
        replacement_cost,
        rating,
        tmdb_id,
        tmdb_poster_path,
        tmdb_backdrop_path
    )
VALUES (
        'khiem ne',
        'This is a sample film description.',
        2023,
        1,
        5,
        7.99,
        120,
        12.99,
        'PG-13',
        12345,
        '/sample_poster.jpg',
        '/sample_backdrop.jpg'
    );
SELECT *
FROM film
WHERE title LIKE '%khiem%';
DELETE FROM film
WHERE title = 'khiem ne';
select *
from film
where title || last_name like #{name} OR email like #{name}");
SELECT staff_id
FROM public.staff
WHERE username = ''
    AND password = 'your_password';