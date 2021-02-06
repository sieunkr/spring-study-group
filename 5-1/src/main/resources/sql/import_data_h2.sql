INSERT INTO HOTEL (id, city, name)
VALUES
  (1, 'SEOUL', 'A Hotel'),
  (2, 'INCHON', 'B Hotel');

INSERT INTO ROOM (id, name, hotel_id, room_status, room_type)
VALUES
  (1, 'room01', 1, 'ON', 'STANDARD'),
  (2, 'room02', 1, 'ON', 'DELUXE');

INSERT INTO CUSTOMER (id, first_name, last_name, phone, email, status)
VALUES
  (1, 'eddy', 'kim', '010-1111-1111', 'sieunkr@gmail.com', 'NORMAL');

INSERT INTO CUSTOMER (id, first_name, last_name, phone, email, status)
VALUES
  (2, 'jinwoo', 'lee', '010-2222-2222', 'jinwoolee2020@gmail.com', 'NORMAL');

  INSERT INTO CUSTOMER (id, first_name, last_name, phone, email, status)
VALUES
  (3, 'tester', 'kim', '010-2222-2222', 'tester@gmail.com', 'NORMAL');


INSERT INTO RESERVATION (id, room_id, adults, children, check_in_date, check_out_date, customer_id, status)
VALUES
  (1, 1, 2, 0, '2020-06-17', '2020-06-20', 1, 'PAYMENT_WAITING');

INSERT INTO RESERVATION (id, room_id, adults, children, check_in_date, check_out_date, customer_id, status)
VALUES
  (2, 1, 1, 0, '2020-06-23', '2020-06-24', 1, 'PAYMENT_COMPLETED');

INSERT INTO RESERVATION (id, room_id, adults, children, check_in_date, check_out_date, customer_id, status)
VALUES
  (3, 2, 2, 2, '2020-06-18', '2020-06-20', 2, 'PAYMENT_COMPLETED');