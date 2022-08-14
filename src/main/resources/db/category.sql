/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

INSERT INTO public.category_group(id, category_group_name)
VALUES (1, 'Mua sắm'),
       (2, 'Tham quan/Giải trí'),
       (3, 'Ăn uống'),
       (4, 'Sự kiện/Hoạt động'),
       (5, 'Di chuyển'),
       (6, 'Lĩnh vực khác');

INSERT INTO public.category(
    id, title, category_group_id)
VALUES (1, 'Nhà hàng', 3),
       (2, 'Cà phê', 3),
       (3, 'Quán ăn', 3),
       (4, 'Công viên', 2),
       (5, 'Khu vui chơi', 2),
       (6, 'Rạp chiếu phim', 2),
       (7, 'Nhà hát', 2),
       (8, 'Thuê xe ô tô', 5),
       (9, 'Thuê xe máy', 5),
       (10, 'Taxi', 5),
       (11, 'Chợ', 1),
       (12, 'Siêu thị', 1),
       (13, 'Trung tâm thương mại', 1),
       (14, 'Shop', 1),
       (15, 'Địa điểm nổi tiếng',2),
       (16, 'Bảo tàng',2);