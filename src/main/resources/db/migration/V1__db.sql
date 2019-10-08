CREATE TABLE `meeting_room_details` (`id` int NOT NULL AUTO_INCREMENT, `capacity` int, `floor` int, `location` varchar(255), `name` varchar(255), PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `meeting_room_details` (`id`, `capacity`, `floor`, `location`, `name`) VALUES (1, 10, 1, 'Pune', 'Room 1');
INSERT INTO `meeting_room_details` (`id`, `capacity`, `floor`, `location`, `name`) VALUES (2, 5, 2, 'Pune', 'Room 2');
CREATE TABLE `scheduler` (`id` int NOT NULL AUTO_INCREMENT, `end_time` datetime, `event_name` varchar(255), `owner` int, `start_time` datetime, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `scheduler` (`id`, `end_time`, `event_name`, `owner`, `start_time`) VALUES (1, '2019-10-20 10:10:00', 'Event A', 1, '2019-10-20 09:10:00');
INSERT INTO `scheduler` (`id`, `end_time`, `event_name`, `owner`, `start_time`) VALUES (2, '2019-10-21 10:10:00', 'Event B', 1, '2019-10-20 09:10:00');
INSERT INTO `scheduler` (`id`, `end_time`, `event_name`, `owner`, `start_time`) VALUES (3, '2019-10-22 10:10:00', 'Event C', 1, '2019-10-20 09:10:00');
CREATE TABLE `schedules_user` (`schedules_id` int NOT NULL, `user_id` bigint NOT NULL, PRIMARY KEY (`schedules_id`, `user_id`), INDEX `FKnokmjoqthg2usxg5vw5x8yq6s` (`user_id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `schedules_user` (`schedules_id`, `user_id`) VALUES (1, 1);
INSERT INTO `schedules_user` (`schedules_id`, `user_id`) VALUES (2, 1);
CREATE TABLE `user` (`id` bigint NOT NULL AUTO_INCREMENT, `email` varchar(200) NOT NULL, `user_password` varchar(255), PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `user` (`id`, `email`, `user_password`) VALUES (1, 'admin@gmail.com', 'admin');

ALTER TABLE `schedules_user` ADD CONSTRAINT `FKjkpiofgq6sq0dhfo1v6qgga75` FOREIGN KEY (`schedules_id`) REFERENCES `scheduler` (`id`) ;
ALTER TABLE `schedules_user` ADD CONSTRAINT `FKnokmjoqthg2usxg5vw5x8yq6s` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);