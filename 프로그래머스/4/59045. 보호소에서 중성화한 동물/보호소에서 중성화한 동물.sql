select o.animal_id, o.animal_type, o.name
from animal_outs o join animal_ins i
    on o.animal_id = i.animal_id
where (i.SEX_UPON_INTAKE LIKE 'Intact%') 
    AND (o.SEX_UPON_OUTCOME LIKE 'Spayed%' OR o.SEX_UPON_OUTCOME like 'Neutered%')
order by o.animal_id asc