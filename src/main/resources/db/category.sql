/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

INSERT INTO public.category_group(id, category_group_name)
VALUES (1, 'Mua sắm'),
       (2, 'Tham quan/Giải trí'),
       (3, 'Ăn uống'),
       (4, 'Sự kiện/Hoạt động'),
       (5, 'Lĩnh vực khác');

INSERT INTO public.category(
    id, title, category_group_id)
VALUES (1, 'Nhà hàng', 4),
       (2, 'Cà phê', 4),
       (3, 'Quán ăn', 4),
       (4, 'Công viên', 2),
       (5, 'Khu vui chơi', 2),
       (6, 'Rạp chiếu phim', 2),
       (7, 'Nhà hát', 2),
       (8, 'Thuê xe ô tô', 5),
       (9, 'Thuê xe máy', 5),
       (10, 'Taxi', 5),
       (11, 'Chợ', 3),
       (12, 'Siêu thị', 3),
       (13, 'Trung tâm thương mại', 3),
       (14, 'Shop', 3),
       (15, 'Địa điểm nổi tiếng',1);