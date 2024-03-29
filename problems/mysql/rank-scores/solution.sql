Create table If Not Exists Scores
(
    Id    int,
    Score DECIMAL(3, 2)
);
Truncate table Scores;
insert into Scores (Id, Score)
values ('1', '3.5');
insert into Scores (Id, Score)
values ('2', '3.65');
insert into Scores (Id, Score)
values ('3', '4.0');
insert into Scores (Id, Score)
values ('4', '3.85');
insert into Scores (Id, Score)
values ('5', '4.0');
insert into Scores (Id, Score)
values ('6', '3.65');

SELECT x.Score AS score, y.`Rank` as `Rank`
FROM Scores x
         LEFT JOIN (
    SELECT Score                             AS score,
           RANK() OVER (ORDER BY Score DESC) AS `Rank`
    FROM Scores
    GROUP BY Score
) AS y ON x.Score = y.Score
ORDER BY Score DESC;