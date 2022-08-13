/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

INSERT  INTO  location (id, address, close_time, description, image_ad, image_card, image_description, latitude, longitude, open_time, title)
 values (1, '01 Lê Trọng Tấn, Thanh Khê District, Da Nang',  current_timestamp + (60 * interval '1 minute'), ' Bãi đá ở Rạn Nam Ô (Đà Nẵng) mùa này đang được khoác lên mình tấm áo xanh mềm mại như nhung. Đó là thảm rêu non vô cùng tươi xanh mát mắt.', 'baidareu.png', 'baidareu.png', 'baidareu.png', 16.037310,108.189160 , CURRENT_TIMESTAMP , 'Bãi Đá Rêu Nam'),
        (2, 'Hoàng Sa, Thọ Quang, Sơn Trà, Đà Nẵng, Vietnam', current_timestamp + (120 * interval '1 minute'), 'Bổ sung bãi Rạng Đà Nẵng vào lịch trình sẽ giúp chuyến du lịch Đà Nẵng của bạn thêm hấp dẫn và đáng nhớ. Vậy bãi Rạng ở đâu, nơi đây có gì đặc sắc mà khiến các tín đồ mê xê dịch yêu thích đến vậy? Tất cả sẽ được bật mí ngay sau đây, đừng bỏ lỡ nhé!', 'bairang.png', 'bairang.png', 'bairang.png', 13.071066, 109.338572 , CURRENT_TIMESTAMP , ' Bãi Rạng Đà Nẵng');