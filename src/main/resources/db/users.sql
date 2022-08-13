/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */
INSERT INTO public.users(
    id, address, avatar, delete_at, email, full_name, password_encode, role, username)
VALUES (1, 'Đà Nẵng', 'avatar1.png', null, 'test@gmail.com','Phạm Văn Nhiều', '123', 'ADMIN', 'Nhieu123'),
       (2, 'Quảng Bình', 'avatar2.png', null, 'duy@gmail.com','Nguyễn Đức Duy', '456', 'USER', 'Duy123'),
       (3, 'Hà Tĩnh', 'avatar3.png', null, 'nghia@gmail.com','Lê Văn Nghĩa', '678', 'USER', 'Nghia456'),
       (4, 'Quảng Bình', 'avatar4.png', null, 'ngan@gmail.com','Võ Ngọc Ngàn', '356', 'USER', 'Ngan098'),
       (5, 'Quảng Trị', 'avatar5.png', null, 'huong@gmail.com','Lê Xuân Huướng', '986', 'USER', 'Huong098');