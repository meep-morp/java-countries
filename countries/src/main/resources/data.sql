-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile
DELETE
FROM countries;

INSERT INTO countries(id, cname, population, land_mass, median_age)
                    VALUES  (1, 'China', 1420062022, 9388211, 39),
                            (2, 'India', 1368737513, 2973190, 28),
                            (3, 'U.S.', 329093110, 9147420, 38),
                            (4, 'Indonesia', 269536482, 1811570, 29),
                            (5,'Brazil', 212392717,8358140, 33),
                            (6, 'Pakistan', 204596442, 770880, 23),
                            (7, 'Nigeria', 200962417, 910770, 18),
                            (8, 'Bangladesh', 168065920, 130170, 27);


alter sequence hibernate_sequence restart with 12;