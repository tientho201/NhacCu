-- Tạo database NhacCu nếu chưa tồn tại
CREATE DATABASE IF NOT EXISTS NhacCu;

-- Sử dụng database NhacCu
USE NhacCu;

-- Tạo bảng Account
CREATE TABLE Account (
  TenDangNhap NVARCHAR(100) NOT NULL,
  password NVARCHAR(100) NOT NULL,
  role NVARCHAR(100) NOT NULL,
  enable INT NOT NULL,
  PRIMARY KEY (TenDangNhap)
);

-- Tạo bảng NhanVien
CREATE TABLE NhanVien (
  MaNhanVien VARCHAR(100)  NOT NULL , 
  TenDangNhap NVARCHAR(100) NOT NULL , 
  TenNhanVien NVARCHAR(100) NOT NULL, 
  GioiTinh NVARCHAR(100) NOT NULL,
  NgaySinh DATE NOT NULL ,
  SDT NVARCHAR(11) NOT NULL , 
  DiaChi NVARCHAR(100) NOT NULL,
  ChucVu NVARCHAR(100) NOT NULL,
  GhiChu NVARCHAR(1000),
  enable INT NOT NULL, 
  PRIMARY KEY (MaNhanVien),
  FOREIGN KEY (TenDangNhap) REFERENCES Account(TenDangNhap)
);

-- Tạo bảng Userr
CREATE TABLE Userr (
  MaUser VARCHAR(100)  NOT NULL , 
  TenDangNhap NVARCHAR(100) NOT NULL , 
  HovaTen NVARCHAR(100) NOT NULL, 
  GioiTinh NVARCHAR(100) NOT NULL,
  NgaySinh DATE NOT NULL ,
  SDT NVARCHAR(11) NOT NULL , 
  DiaChi nVARCHAR(100) NOT NULL,
  GhiChu NVARCHAR(1000),
  enable INT NOT NULL, 
  PRIMARY KEY (MaUser),
  FOREIGN KEY (TenDangNhap) REFERENCES Account(TenDangNhap)
);

-- Tạo bảng NhaSanXuat
CREATE TABLE NhaSanXuat(
  MaNSX VARCHAR(10) NOT NULL PRIMARY KEY , 
  TenNSX NVARCHAR(100) NOT NULL
);

-- Tạo bảng NhaCungCap
CREATE TABLE NhaCungCap(
  MaNCC VARCHAR(10) NOT NULL PRIMARY KEY , 
  TenNCC NVARCHAR(100) NOT NULL,
  DiaChiNCC NVARCHAR(100) NOT NULL , 
  SDTNCC VARCHAR(20) NOT NULL , 
  GhiChu NVARCHAR(100) NOT NULL
);

-- Tạo bảng Loai
CREATE Table Loai(
  MaLoai VARCHAR(10) NOT NULL PRIMARY KEY , 
  TenLoai NVARCHAR(100) NOT NULL 
);

-- Tạo bảng SanPham
CREATE TABLE SanPham(
  MaSP VARCHAR(10) NOT NULL PRIMARY KEY , 
  TenSP NVARCHAR(100) NOT NULL , 
  SoLuong int NOT NULL , 
  Gia int NOT NULL , 
  MaLoai VARCHAR(10) NOT NULL  , 
  MaNSX VARCHAR(10) NOT NULL ,
  Image NVARCHAR(1000),
  GhiChu NVARCHAR(1000), 
  FOREIGN KEY (MaNSX) REFERENCES NhaSanXuat(MaNSX),
  FOREIGN KEY (MaLoai) REFERENCES Loai(MaLoai)
);

-- Tạo bảng HoaDon
CREATE TABLE HoaDon(
  MaHD VARCHAR(10) NOT NULL PRIMARY KEY , 
  MaNhanVien VARCHAR(100)  NOT NULL ,  
  MaUser VARCHAR(100)  NOT NULL , 
  NgayLap DATE NOT NULL ,
  TongTien int NOT null, 
  Enable INT NOT NULL , 
  ThanhToan INT NOT NULL , 
  FOREIGN KEY (MaUser) REFERENCES Userr(MaUser),
  FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

-- Tạo bảng ChiTietHD
CREATE TABLE ChiTietHD(
  MaSP VARCHAR(10) NOT NULL , 
  MaHD VARCHAR(10) NOT NULL , 
  SoLuong int NOT NULL , 
  Gia int NOT NULL ,
  ThoiGianBaoHanh INT NOT NULL , 
  GhiChu NVARCHAR(1000) , 
  PRIMARY KEY (MAHD, MASP),
  FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP),
  FOREIGN KEY (MAHD) REFERENCES HoaDon(MAHD)
);

-- Tạo bảng PhieuNhap
CREATE TABLE PhieuNhap(
  MaPNH VARCHAR(10) NOT NULL PRIMARY KEY , 
  MaNCC VARCHAR(10) NOT NULL,
  MaNhanVien VARCHAR(100)  NOT NULL , 
  NgayNhap DATE NOT NULL ,
  TongTien INT NOT NULL ,
  Enable INT NOT NULL , 
  FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC),
  FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

-- Tạo bảng ChiTietPhieuNhap
CREATE TABLE ChiTietPhieuNhap(
  MaSP VARCHAR(10) NOT NULL , 
  MaPNH VARCHAR(10) NOT NULL , 
  DonGiaNhap int not NULL , 
  SoLuong int NOT NULL ,  
  GhiChu NVARCHAR(1000) ,
  PRIMARY KEY (MaSP, MaPNH),
  FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP), 
  FOREIGN KEY (MaPNH) REFERENCES PhieuNhap(MaPNH)
);

-- Tạo bảng PhieuBaoTri
CREATE TABLE PhieuBaoTri(
  MaBT VARCHAR(10) NOT NULL PRIMARY KEY , 
  MaNhanVien VARCHAR(100)  NOT NULL , 
  MaUser VARCHAR(100) NOT NULL,
  MaHD VARCHAR(10) NOT NULL , 
  NgayLap DATE NOT NULL ,
  Enable INT NOT NULL , 
  FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
  FOREIGN KEY (MaUser) REFERENCES Userr(MaUser),
  FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

-- Tạo bảng ChiTietPhieuBaoTri
CREATE TABLE ChiTietPhieuBaoTri(
  MaSP VARCHAR(10) NOT NULL , 
  MaBT VARCHAR(10) NOT NULL , 
  GhiChu NVARCHAR(1000) ,
  PRIMARY KEY (MaSP, MaBT),
  FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP), 
  FOREIGN KEY (MaBT) REFERENCES PhieuBaoTri(MaBT)
);


INSERT INTO Account (TenDangNhap, password, role , enable ) VALUES
( 'admin', 'admin', 'Admin' , 1  ),
('sale', 'sale', 'NhanVien'  , 0),
('sale1', 'sale', 'NhanVien' , 0 ),
('sale2', 'sale', 'NhanVien' , 0),
('sale3', 'sale', 'NhanVien' , 0 ),
('sale4', 'sale', 'NhanVien' , 1),
('sale5', 'sale', 'QLK'  , 0),
('sale6', 'sale', 'QLK' , 0 ),
('sale7', 'sale', 'QLK' , 1),
('sale8', 'sale', 'QLK' , 0 ),
('sale9', 'sale', 'QLK' , 1),
( 'HAI', 'HAI', 'NhanVien' , 1),
( 'KHANH', 'KHANH', 'NhanVien', 1 ),
( 'TRUONG', 'TRUONG', 'NhanVien' , 1 ),
('TRUONG11', 'TRUONG11', 'NhanVien' , 1 ),
( 'TRUONG13', 'TRUONG13', 'NhanVien' , 1),
('user', 'user', 'KhachHang' , 1 ),
( 'zxc', 'zxc', 'KhachHang' , 1 ),
( 'cdn', 'cdn', 'ChuDoanhNghiep' , 1 );



INSERT INTO NhanVien (MaNhanVien , TenDangNhap, TenNhanVien, GioiTinh, NgaySinh, SDT, DiaChi ,ChucVu,GhiChu, enable ) VALUES
('CDN1','cdn', 'Chủ Doanh Nghiệp', 'Nam','2012-05-12', '0123456798', N'Việt Nam' ,'cdn',N'', 1 ),
('NV1','HAI', 'NGUYEN NGOC HAI', 'Nam','2012-05-12', '0123456798', N'Việt Nam' ,'NhanVien',N'', 1 ),
('NV2','KHANH', 'KHANH YASUA', 'Nam', '2012-05-12', '123456789', N'Việt Nam' ,'NhanVien',N'', 1),
('NV3','TRUONG', 'XUAN TRUONG', 'Nam', '2012-05-12', '123456789', N'Việt Nam' ,'NhanVien',N'', 1),
('NV4','TRUONG11', 'XUAN TRUONG' ,'Nam', '2012-05-12', '123456789', N'Việt Nam','NhanVien',N'', 1),
('NV5','TRUONG13', 'XUAN TRUONG', 'Nữ', '2012-05-12', '123456789', N'Việt Nam' , 'NhanVien',N'', 1),
('NV6','sale', 'Sale1', 'Nữ','2024-01-12', '0384475805', N'Việt Nam' ,'NhanVien',N'', 0 ),
('NV7','sale1', 'Sale2', 'Nữ','2024-01-12', '0384475805', N'Việt Nam', 'NhanVien' ,N'', 0),
('NV8','sale2', 'Sale3', 'Nữ','2024-01-12', '0384475805', N'Việt Nam' , 'NhanVien' ,N'', 0),
('NV9','sale3', 'Sale4', 'Nữ','2024-01-12', '0384475805', N'Việt Nam', 'NhanVien',N'', 0),
('NV10','sale4', 'Sale5', 'Nữ','2024-01-12', '0384475805', N'Việt Nam', 'NhanVien' ,N'', 1),
('QLK1','sale5', 'Sale5', 'Nữ','2024-01-12', '0384475805', N'Việt Nam' ,'QLK',N'', 0 ),
('QLK2','sale6', 'Sale6', 'Nữ','2024-01-12', '0384475805', N'Việt Nam', 'QLK' ,N'', 0),
('QLK3','sale7', 'Sale7', 'Nữ','2024-01-12', '0384475805', N'Việt Nam' , 'QLK' ,N'', 1),
('QLK4','sale8', 'Sale8', 'Nữ','2024-01-12', '0384475805', N'Việt Nam', 'QLK',N'', 0),
('QLK5','sale9', 'Sale9', 'Nữ','2024-01-12', '0384475805', N'Việt Nam', 'QLK' ,N'', 1),
('AD1','admin', 'Admin', 'Nam','2024-01-12', '0384475805', N'Việt Nam', 'Admin' ,N'', 1);

INSERT INTO Userr  (MaUser, TenDangNhap, HovaTen, GioiTinh, NgaySinh, SDT, DiaChi ,GhiChu, enable  ) VALUES
('Us1','zxc', 'zxc', 'Nam','2012-05-12', '0123456798', N'Việt Nam' , N'',1),
('Us2','user', 'zxc', 'Nam','2012-05-12', '0123456798', N'Việt Nam' ,N'',1 );

INSERT INTO NhaCungCap(MaNCC , TenNCC , DiaChiNCC , SDTNCC , GhiChu ) VALUES
('NCC1' ,  N'NCC TP Đà Nẵng', N'Đà Nẵng', '123123123 ',N'Nhà Cung Cấp Số 1'),
('NCC2' ,  N'NCC TP Hà Nội', N'Hà Nội', '123123123  ',N'Nhà Cung Cấp Số 2'),
('NCC3' ,  N'NCC TP Hồ Chí Minh', N'Hồ Chí Minh', '123123123  ',N'Nhà Cung Cấp Số 3'),
('NCC4' ,  N'NCC TP Nha Trang', N'Nha Trang', '123123123  ',N'Nhà Cung Cấp Số 4'),
('NCC5' ,  N'NCC TP Huế', N'Huế', '123123123  ',N'Nhà Cung Cấp Số 5');

INSERT INTO Loai(MaLoai , TenLoai) VALUES
('L1', N'Đàn Piano'),
('L2', N'Đàn Violin'),
('L3', N'Đàn Organ'),
('L4', N'Kèn-Sáo'),
('L5', N'Trống'),
('L6', N'Đàn Guitar');

INSERT INTO NhaSanXuat(MaNSX , TenNSX) VALUES
('NSX1', N'Việt Nam'),
('NSX2', N'Hàn Quốc'),
('NSX3', N'Trung Quốc'),
('NSX4', N'Thái Lan'),
('NSX5', N'Nhật Bản'),
('NSX6', N'Singapo');

INSERT INTO SanPham(MaSP , TenSP , SoLuong, Gia , MaLoai , MaNSX ,Image, GhiChu) VALUES
(N'SP1', N'Đàn Piano Apollo A8',10,550300 , N'L1', N'NSX1', N'' ,N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...'),
(N'SP2', N'Đàn Violin Antonius Braun',10,252000 , N'L2', N'NSX1',  N'' , N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...'),
(N'SP3', N'Đàn Violin Azmusic AZV130',10,155040 , N'L2', N'NSX5', N'' ,  N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...'),
(N'SP4', N'Đàn Violin Kapok V182',10,512400 , N'L2', N'NSX1', N'' ,  N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...'),
(N'SP5', N'Đàn Piano01',10,557000 , N'L1', N'NSX1', N'' ,  N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...'),
(N'SP6', N'Đàn Piano Yamaha W106',10,552000 , N'L1', N'NSX3', N'' ,  N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...'),
(N'SP7', N'Đàn Violin Kapok V188',10,525000 , N'L2', N'NSX1', N'' ,  N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...'),
(N'SP8', N'Đàn Guitar Acoustic J260',10,155000 , N'L6', N'NSX2', N'' ,  N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...');

INSERT INTO HoaDon(MaHD , MaNhanVien , MaUser , NgayLap , TongTien, Enable , ThanhToan ) VALUES
('HD1' , 'NV1' , 'Us2' , '2024-03-20'  , 4000000 , 1 , 1),
('HD2' , 'NV2' , 'Us2' , '2024-03-27'  , 4000000 , 1 , 0);


INSERT INTO ChiTietHD(MaSP , MaHD , SoLuong , Gia , ThoiGianBaoHanh , GhiChu ) VALUES
(N'SP1' , N'HD1' ,5, 400000 , 2  , N''),
(N'SP2' , N'HD1' ,5, 400000 , 2  , N'');

INSERT INTO PhieuNhap(MaPNH , MaNCC ,MaNhanVien , NgayNhap , TongTien , Enable) VALUES 
(N'PN1' , N'NCC2' , N'QLK3' , N'2024-03-27' , 750000 , 1 ),
(N'PN2' , N'NCC2' , N'QLK3' , N'2024-03-28' , 1100000 , 1 ),
(N'PN3' , N'NCC5' , N'QLK3' , N'2024-03-29' , 1550000 , 1 );


INSERT INTO ChiTietPhieuNhap(MaSP , MaPNH , DonGiaNhap , SoLuong  , GhiChu ) VALUES
(N'SP1' , N'PN1' , 40000 , 10  , N''),
(N'SP2' , N'PN1' , 50000 , 5  , N''),
(N'SP6' , N'PN1' , 20000 , 5  , N''),
(N'SP6' , N'PN2' , 20000 , 5   , N''),
(N'SP7' , N'PN2' , 40000 , 10  , N''),
(N'SP8' , N'PN2' , 10000 , 10  , N''),
(N'SP3' , N'PN2' , 50000 , 10  , N''),
(N'SP2' , N'PN3' , 50000 , 5  , N''),
(N'SP4' , N'PN3' , 50000 , 10  , N''),
(N'SP5' , N'PN3' , 80000 , 10  , N'');