-- Tinh luong 1 nguoi. 
select sum(if(cx.lai_xe_id = 45, 2, 1) * 10 * tx.do_phuc_tap) as luong
from chuyen_xe cx
	join tuyen_xe tx on cx.tuyen_xe_id = tx.tuyen_xe_id
where (cx.lai_xe_id =  44 or cx.phu_xe_id = 44)
	and year(cx.ngay_di) = 2020
    and month(cx.ngay_di) = 12;

-- tai_xe_id 
select * from tuyen_xe;
select * from chuyen_xe;
select * from tai_xe;

-- Tinh luong toan bo. Luong co ban cua phu xe = 10 * 1 (2,3) tuy vao do phuc tap tuyen xe.
select tx.tai_xe_id, tx.ten, ifnull(sum(if(cx.lai_xe_id = tx.tai_xe_id, 2, 1) * 10 * txe.do_phuc_tap), 0)  as luong
from tai_xe tx 
left join chuyen_xe cx on tx.tai_xe_id = cx.lai_xe_id or tx.tai_xe_id = cx.phu_xe_id
left join tuyen_xe txe using(tuyen_xe_id)
where 	(year(cx.ngay_di) = 2020 and month(cx.ngay_di) = 12)
		or cx.ngay_di is NULL
group by tx.tai_xe_id;

-- Tinh doanh thu xe khach.
use transportationmanagementsystem;
select xe.xe_khach_id, xe.bien_so, ifnull(sum(cx.so_khach * cx.gia_ve), 0) as doanhThu
from xe_khach xe
left join chuyen_xe cx on xe.xe_khach_id = cx.xe_khach_id where cx.ngay_di between '1999-10-01' and '2021-12-20'
group by xe.xe_khach_id order by doanhThu;

-- Nháp
select *
from tai_xe tx 
left join chuyen_xe cx on tx.tai_xe_id = cx.lai_xe_id or tx.tai_xe_id = cx.phu_xe_id
left join tuyen_xe txe using(tuyen_xe_id)
where 	(year(cx.ngay_di) = 2020 and month(cx.ngay_di) = 12)
		or cx.ngay_di is NULL
group by tx.tai_xe_id;
