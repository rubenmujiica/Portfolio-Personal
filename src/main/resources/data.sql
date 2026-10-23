INSERT INTO personal_info (first_name, last_name, title, profile_description, profile_image_url, years_of_experience, email, phone, linkedin_url, github_url) VALUES
    ('Rubén', 'Mújica Sánchez', 'Junior Software Engineer | Backend & Software Developer', 'Software Engineer skilled in backend development and system design using Java and Spring Boot. Driven by clean code, algorithm optimization, and continuous learning.', 'img/dev-ruben.jpg', 1, 'rubenmujicasanchez@gmail.com', '+34 684 35 36 54', 'https://www.linkedin.com/in/rub%C3%A9n-m%C3%BAjica-s%C3%A1nchez-035ab2374/', 'https://github.com/rubenmujiica');

INSERT INTO skills (name, level_percentage, icon_class, personal_info_id) VALUES
    ('Java', 90, 'img/logos/java.png', 1),
    ('C++', 70, 'img/logos/cplusplus.png', 1),
    ('Python', 70, 'img/logos/python.png', 1),
    ('PHP', 70, 'img/logos/php.png', 1),
    ('HTML', 95, 'img/logos/html-5.png', 1),
    ('CSS', 90, 'img/logos/css-3.png', 1),
    ('MySQL', 80, 'img/logos/mysql.png', 1),
    ('Docker', 80, 'img/logos/docker.png', 1),
    ('Linux', 80, 'img/logos/linux.png', 1),
    ('GitHub', 85, 'img/logos/github.png', 1);

INSERT INTO educations (degree, institution, start_date, end_date, description, personal_info_id) VALUES
    ('Bachelor’s Degree in Computer Engineering', 'Universidad de Cádiz', '2021-09-15', '2026-09-24', 'Focused on software engineering, database management, object-oriented programming, and computer architecture.', 1),
    ('High School Diploma in Science and Technology', 'Instituto Lola Flores', '2019-09-01', '2021-05-15', 'Focused on mathematics, physics, fundamentals of technology, and logical problem-solving.', 1),
    ('Java & Spring Boot Course', 'Udemy', '2026-06-01', '2026-09-1', 'In-depth training in RESTful APIs, microservices architecture, JPA/Hibernate, Docker, and Spring Security with JWT.', 1);

INSERT INTO experiences (job_title, company_name, start_date, end_date, description, personal_info_id) VALUES
    ('Software Developer (Internship)', 'Gaboral', '2025-04-08', '2025-08-04', 'IT Support and software development for product management systems.Technologies: PHP + Laravel, CSS, HTML', 1),
    ('Web Developer (Internship)', 'Asociación Las Canteras', '2024-03-01', '2024-06-15', 'Web support and hosting management. Technologies: Wordpress, CSS', 1);

INSERT INTO projects (title, description, image_url, project_url, personal_info_id) VALUES
    ('Gestor de Gastos', 'Aplicación personal para llevar un control de mis gastos personales. Java & SpringBoot, React + TypeScript','img/projects/gestor-gastos.png', 'https://github.com/rubenmujiica/Gestor-de-Gastos.git', 1),
    ('Trabajo de Fin de Grado', 'Plataforma de Eye Tracking basado en webcam. Python & JavaScript', 'img/projects/eyetrack.png', 'https://github.com/rubenmujiica/TFG-EyeTracking-RubenMujicaSanchez.git', 1),
    ('Gaboral Stock', 'Plataforma para la gestión de stock de un almacén. PHP/Laravel', 'img/projects/stock.png', 'https://github.com/rubenmujiica/Gaboral-Stock.git', 1),
    ('Pokeshop', 'Plataforma de compra-venta de cartas Pokemon. PHP/Laravel', 'img/projects/poke.png', 'https://github.com/rubenmujiica/PokeShow.git', 1),
    ('Find a Car', 'Plataforma de alquiler de coches. HTML, CSS & JavaScript', 'img/projects/findacar.png', 'https://github.com/rubenmujiica/Find-a-Car.git', 1);

INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$X74u8EroWpq2q.WBTYX3GuhwF2Sd8CfzV7Jv2QVtO9QRlz7Zfmn8y', TRUE);