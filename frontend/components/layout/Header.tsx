import {IoLogoDocker} from "react-icons/io5"
import {FiMenu, FiUser} from "react-icons/fi"
import Hamburger from "hamburger-react"

declare interface HeaderProps {
    toggleSidebar: () => void;
    sideBarExtended: boolean
}

const Header = ({ toggleSidebar, sideBarExtended }: HeaderProps) => {
    return (
        <div className="flex fixed top-0 left-0 z-30 justify-between py-3 px-5 w-full bg-blue-400">
            <div className="lg:hidden text-white">
                <Hamburger toggled={sideBarExtended} toggle={toggleSidebar} size={24} />
            </div>
            <a
                href="https://github.com/prismarin-network/docker-dashboard"
                target="_blank"
                className="flex items-center text-white hover:text-gray-100">
                <IoLogoDocker size="2rem"/>
                <span className="hidden lg:block ml-2 text-xl font-outfit">
                    Docker Dashboard
                </span>
            </a>
            <div className="flex justify-center items-center text-white w-[48px] h-[48px]">
                <FiUser size="28px" />
            </div>
        </div>
    )
}

export default Header
