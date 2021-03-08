

import java.util.ArrayList;

public class Manager {
	private BitDB db;

	public Manager() {
		db = new BitDB();
		db.Run();
	}



	//USER -------------------------------------------------------
	public boolean MakeUser(String memberid, String name) {	
		return db.MakeUser(memberid, name);
	}
	
	public void SelectAllUser() {
		db.SelectAllUser();
	}
	
	
	public boolean InsertDrink(String name, int cost) {
		return db.InsertDrink(name, cost);
		
	}
	
	public boolean UpdatememberLevel(String memberid) {
		return db.UpdateMemberLevel(memberid);
	}
	
	public void SelectAllDrink() {
		db.SelectAllDrink();
	}
	
	public void SelectAllLevel() {
		db.SelectAllLevel();
	}
	
	public void SelectAllBuyDrink() {
		db.SelectAllBuyDrink();
	}
	
	public boolean InsertBuyDrink(String memberid, int drinkid, int count) {
		return db.InsertBuyDrink(memberid, drinkid, count);
	}
	
	public void SelectMostPopularDrink() {
		db.SelectMostPopularDrink();
	}
	
	public void SelectMemberBuy(String memberid) {
		db.SelectMemberBuy(memberid);
	}
//
//	public boolean PayCharge(String id, int money)	{
//		return db.PayCharge(id, money);
//	}
//
//	public boolean refundCharge(String id, int money) {
//		return db.refundCharge(id, money);
//	}
//
//	public User SelectUser(String id) {
//		return db.SelectUser(id);
//	}
//
//	public ArrayList<User> SelectAllUser() {
//		return db.SelectAllUser();
//	}

//	public boolean DeleteUser(String id) {
//		return db.DeleteUser(id);
//	}
//
//	//SRT -------------------------------------------------
//	public boolean MakeSRT(int srt_number, int max_seat, int Charge) {
//		return db.MakeSRT(srt_number, max_seat, Charge);
//	}
//
//	public SRT selectSrt(int srt_number) {
//		return db.SelectSRT(srt_number);
//	}
//
//	public ArrayList<SRT> selectSrtAll() {
//		return db.SelectAllSRT();
//	}

	// Reservation -----------------------------------------

//	// 구매와 돈 인출이 하나의 트랜잭션으로 관리되는 메서드
//	public boolean Reservation(String id, int balance, int srt_number, int seat_number) {
//		SRT srt = db.SelectSRT(srt_number);
//		srt.Choice_Seat(seat_number); // 좌석 현황 변경
//		return db.Reservation(id, balance, srt_number, seat_number, srt.getSeat_state());
//	}
//
//	// 예약 취소와 돈 환불이 하나의 트랜잭션으로 관리되는 메서드
//	public boolean CancleReservation(String id, int money, int r_id, int srtnumber) {
//		SRT srt = db.SelectSRT(srtnumber);
//		srt.Cancle_Seat(srtnumber); // 좌석 현황 변경
//		return db.CancleReservation(id, money, r_id, srt.getSeat_state(), srtnumber);
//	}
//
//	public boolean ReservationSeat(String id, int srt_number, int seat_number) {
//		return db.ReservationSeat(id, srt_number, seat_number);
//	}
//
//	public boolean ChangeSeatRId(int r_id, String user_id, int srt_number, int seat_number) {
//		return db.ChangeSeatRId(r_id, user_id, srt_number, seat_number);
//	}
//
//	public boolean DeleteReservationRId(String user_id, int r_id) {
//		return db.DeleteReservationRId(user_id, r_id);
//	}
//
//	public ArrayList<Reservation> SelectReservationUserId(String id){
//		return db.SelectReservationUserId(id);
//	}
//
//	public Reservation SelectReservationRId(int id) {
//		return db.SelectReservationRId(id);
//	}
//
//	public ArrayList<Reservation> SelectReservationAll(){
//		return db.SelectReservationAll();
//	}
}
